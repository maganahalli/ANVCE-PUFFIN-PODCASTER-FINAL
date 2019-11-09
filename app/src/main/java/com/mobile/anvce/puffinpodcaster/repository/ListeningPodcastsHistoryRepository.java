package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.AppDatabase;
import com.mobile.anvce.puffinpodcaster.database.DbListeningHistory;
import com.mobile.anvce.puffinpodcaster.database.PuffinPodcastsDao;
import com.mobile.anvce.puffinpodcaster.executors.AppExecutors;
import com.mobile.anvce.puffinpodcaster.transformers.DbListeningHistoryFromEpisode;
import com.mobile.anvce.puffinpodcaster.transformers.EpisodeFromDbListeningHistory;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class ListeningPodcastsHistoryRepository extends BasePodcastsRepository {

	private static final String TAG = ListeningPodcastsHistoryRepository.class.getSimpleName();
	private PuffinPodcastsDao podcastDao;
	private List<Episode> listeningHistory = new ArrayList<>();

	private MutableLiveData<List<Episode>> mutableLiveData = new MutableLiveData<>();

	public ListeningPodcastsHistoryRepository(@NonNull Context context) {
		super(context);
		podcastDao = AppDatabase.getInstance(context.getApplicationContext()).podcastsDao();
		Log.d(TAG, "Actively getting data from Database");
	}

	public MutableLiveData<List<Episode>> getMutableLiveData() {
		AppExecutors.getInstance().diskIO().execute(() -> {
			listeningHistory.clear();
			Episode header = new Episode();
			header.setHeader(true);
			listeningHistory.add(header);
			listeningHistory.addAll(new EpisodeFromDbListeningHistory().transformAll(podcastDao.fetchListeningHistory()));
			AppExecutors.getInstance().mainThread().execute(new Runnable() {
				@Override
				public void run() {
					mutableLiveData.setValue(listeningHistory);
				}
			});

		});
		return mutableLiveData;
	}

	public void saveEpisodeToListeningHistoryDatabase(@NonNull Episode episodeItem) {
		AppExecutors.getInstance().diskIO().execute(() -> {
			DbListeningHistory history = new DbListeningHistoryFromEpisode().transform(episodeItem);
			final DbListeningHistory retrievedRecord = podcastDao.retrieveListeningHistoryById(episodeItem.getId());
			if (retrievedRecord != null) {
				Log.d(TAG, "Updated Listening History");
				podcastDao.updateListeningHistory(history);
			} else {
				Log.d(TAG, "Inserting  Listening History");
				podcastDao.insertListeningHistory(history);
			}

		});

	}

}
