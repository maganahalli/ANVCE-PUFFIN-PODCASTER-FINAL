package com.mobile.anvce.puffinpodcaster.repository;

import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.AppDatabase;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.database.PuffinPodcastsDao;
import com.mobile.anvce.puffinpodcaster.executors.AppExecutors;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.transformers.DbEpisodeFromEpisode;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class PlayFavoriteEpisodeRepository extends BasePodcastsRepository implements PuffinPodcasterConstants {

	private static final String TAG = PlayFavoriteEpisodeRepository.class.getSimpleName();
	private PuffinPodcastsDao podcastDao;
	private final LiveData<List<DbEpisode>> dbEpisodeList;

	public final LiveData<List<DbEpisode>> getDbEpisodeList() {
		return dbEpisodeList;
	}

	public PlayFavoriteEpisodeRepository(@NonNull Context context) {
		super(context);
		podcastDao = AppDatabase.getInstance(context.getApplicationContext()).podcastsDao();
		dbEpisodeList = podcastDao.loadAllPlayLaterEpisodes(PLAY_LIST);
		Log.d(TAG, "Actively retrieving tha Favorite Episode list from Database");
	}


	public void deleteEpisodeFromFavoriteList(@NonNull Episode episodeItem){
		final DbEpisode dbEpisode = new DbEpisodeFromEpisode().transform(episodeItem);
		dbEpisode.setCategory(PLAY_LIST);

		AppExecutors.getInstance().diskIO().execute(() -> {
			final DbEpisode retrievedRecord = podcastDao.retrieveEpisodeById(episodeItem.getId());
			if (retrievedRecord != null && PLAY_LIST.equals(retrievedRecord.getCategory())) {
				Log.d(TAG, "deleted Episode Play List/ Favorite option");
				podcastDao.deleteEpisode(retrievedRecord);
			}
		});
	}

}
