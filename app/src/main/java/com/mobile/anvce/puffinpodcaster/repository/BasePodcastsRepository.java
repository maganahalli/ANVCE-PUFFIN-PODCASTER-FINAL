package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.PuffinPodcastService;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.database.AppDatabase;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedList;
import com.mobile.anvce.puffinpodcaster.database.DbPodcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.database.PuffinPodcastsDao;
import com.mobile.anvce.puffinpodcaster.enums.SupportedRegions;
import com.mobile.anvce.puffinpodcaster.executors.AppExecutors;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.network.RetrofitPuffinPodcasterClient;
import com.mobile.anvce.puffinpodcaster.transformers.DbCuratedListFromCuratedList;
import com.mobile.anvce.puffinpodcaster.transformers.DbPodcastFromPodcast;
import com.mobile.anvce.puffinpodcaster.util.PodcastsUtil;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class BasePodcastsRepository implements PuffinPodcasterConstants {

	private static final String TAG = BasePodcastsRepository.class.getSimpleName();
	private PodcastsUtil podcastUtil;
	private PuffinPodcastsDao podcastDatabaseDao;
	// Shared preferences object
	private SharedPreferences mPreferences;
	private LiveData<List<DbPodcast>> dbPodcastList = new MutableLiveData<>();

	public PuffinPodcastService getService() {
		return service;
	}

	final PuffinPodcastService service = RetrofitPuffinPodcasterClient.getRetrofitInstance().create(PuffinPodcastService.class);

	public BasePodcastsRepository() {

	}

	public BasePodcastsRepository(@NonNull Context context) {
		podcastUtil = new PodcastsUtil(context);
		mPreferences = context.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
		podcastDatabaseDao = AppDatabase.getInstance(context).podcastsDao();
		dbPodcastList = podcastDatabaseDao.loadAllPodcasts();
	}

	public LiveData<List<DbPodcast>> getDbPodcastList() {
		return dbPodcastList;
	}

	protected ArrayList<Podcast> buildPodcastList(@NonNull String jsonString) {
		ArrayList<Podcast> podcastList = new ArrayList<>();
		final List<Podcast> localPodcastsList = podcastUtil.extractPodcastList(jsonString);
		if (!localPodcastsList.isEmpty()) {
			podcastList.clear();
			podcastList.addAll(localPodcastsList);
			persistPodcastDataToSharedPreference(new PodcastCustomDataConverter().fromPodcastList(podcastList));
			persistPodcastDataToDatabase(podcastList);
		}
		return podcastList;
	}

	protected void persistPodcastDataToDatabase(ArrayList<Podcast> podcastList) {
		for (Podcast podcast : podcastList) {
			DbPodcast dbpodcast = new DbPodcastFromPodcast().transform(podcast);
			persistItemToDatabase(dbpodcast, podcast);
		}
	}

	protected void persistCuratedListDataToDatabase(List<CuratedList> cuaratedListList) {
		for (CuratedList cuaratedList : cuaratedListList) {
			DbCuratedList dbCuratedList = new DbCuratedListFromCuratedList().transform(cuaratedList);
			persistCuratedListItemToDatabase(dbCuratedList, cuaratedList);
		}
	}

	private void persistCuratedListItemToDatabase(DbCuratedList dbCuratedList, CuratedList cuaratedList) {

		AppExecutors.getInstance().diskIO().execute(() -> {
			DbCuratedList retrievedRecord = podcastDatabaseDao.retrieveCuratedListById(cuaratedList.getId());
			if (retrievedRecord != null) {
				if (retrievedRecord.getCuratedListId().equals(cuaratedList.getId())) {
					Log.d(TAG, "Updating CuratedList with id :" + cuaratedList.getId() + "");
					podcastDatabaseDao.updateCuratedList(dbCuratedList);
				}
				return;
			}
			Log.d(TAG, "Updating Cuarated List with id :" + dbCuratedList.getCuratedListId() + "");
			podcastDatabaseDao.insertCuratedList(dbCuratedList);
		});
	}

	protected void persistItemToDatabase(DbPodcast dbpodcast, Podcast podcast) {

		AppExecutors.getInstance().diskIO().execute(() -> {
			DbPodcast retrievedRecord = podcastDatabaseDao.retrievePodcastById(podcast.getId());
			if (retrievedRecord != null) {
				if (retrievedRecord.getPodcastId().equals(podcast.getId())) {
					Log.d(TAG, "Updating Podcast with id :" + podcast.getId() + "");
					podcastDatabaseDao.updatePodcast(dbpodcast);
				}
				return;
			}
			Log.d(TAG, "Updating Podcast with id :" + dbpodcast.getPodcastId() + "");
			podcastDatabaseDao.insertPodcast(dbpodcast);
		});

	}

	// Restore preferences
	protected ArrayList<Podcast> restorePopularPodcastSharedPreference() {
		ArrayList<Podcast> podcastList = new ArrayList<>();
		String popularPodcastAsString = mPreferences.getString(PREF_POPULAR_PODCAST_KEY, "");
		if (TextUtils.isEmpty(popularPodcastAsString)) {
			return podcastList;
		}
		List<Podcast> localList = new PodcastCustomDataConverter().toPodcastListFromSharePref(popularPodcastAsString);
		podcastList.clear();
		podcastList.addAll(localList);
		return podcastList;
	}

	protected String getSupportedRegionCode() {
		String region = mPreferences.getString(PuffinPodcasterConstants.PREF_REGION_KEY, "USA");
		SupportedRegions regionOption = SupportedRegions.fromString(region);
		return regionOption.getRegionCode();
	}

	protected void persistPodcastDataToSharedPreference(String popularPodcastListAsString) {
		if (TextUtils.isEmpty(popularPodcastListAsString) || mPreferences == null) {
			return;
		}
		SharedPreferences.Editor preferencesEditor = mPreferences.edit();
		preferencesEditor.putString(PREF_POPULAR_PODCAST_KEY, popularPodcastListAsString);
		preferencesEditor.apply();
	}

	protected void persistSearchResultDataToSharedPreference(String keyPostfix, String searchResultListAsString) {
		if (TextUtils.isEmpty(searchResultListAsString) || mPreferences == null) {
			return;
		}
		SharedPreferences.Editor preferencesEditor = mPreferences.edit();
		preferencesEditor.putString(PREF_SEARCH_PODCAST_KEY + "_" + keyPostfix, searchResultListAsString);
		preferencesEditor.apply();
	}

	// Restore preferences
	protected List<SearchResultByKeyWord> restoreSearchResultistSharedPreference(String searckKeyPostFix) {
		List<SearchResultByKeyWord> curatedLists = new ArrayList();
		String searchResultListAsString = mPreferences.getString(PREF_SEARCH_PODCAST_KEY + "_" + searckKeyPostFix, "");
		if (TextUtils.isEmpty(searchResultListAsString)) {
			return curatedLists;
		}
		List<SearchResultByKeyWord> localList = new PodcastCustomDataConverter().toSearchList(searchResultListAsString);
		curatedLists.clear();
		curatedLists.addAll(localList);
		return curatedLists;
	}

	// Restore preferences
	protected List<CuratedList> restoreCuratedListSharedPreference() {
		List<CuratedList> curatedLists = new ArrayList();
		String curatedListAsString = mPreferences.getString(PREF_CURATED_LIST_KEY, "");
		if (TextUtils.isEmpty(curatedListAsString)) {
			return curatedLists;
		}
		List<CuratedList> localList = new PodcastCustomDataConverter().toCuratedListFromSharePref(curatedListAsString);
		curatedLists.clear();
		curatedLists.addAll(localList);
		return curatedLists;
	}

	protected void saveCuratedPodcastListToSharedPrefrences(String curatedListAsString) {
		if (TextUtils.isEmpty(curatedListAsString) || mPreferences == null) {
			return;
		}
		SharedPreferences.Editor preferencesEditor = mPreferences.edit();
		preferencesEditor.putString(PREF_CURATED_LIST_KEY, curatedListAsString);
		preferencesEditor.apply();
	}

	protected List<CuratedList> buildCuratedList(@NonNull String jsonString) {
		List<CuratedList> curatedLists = new ArrayList();
		final List<CuratedList> localPodcastsList = podcastUtil.extractCuratedList(jsonString);
		if (!localPodcastsList.isEmpty()) {
			curatedLists.clear();
			curatedLists.addAll(localPodcastsList);
			saveCuratedPodcastListToSharedPrefrences(new PodcastCustomDataConverter().fromCuratedtList(curatedLists));
		}
		return curatedLists;
	}

}
