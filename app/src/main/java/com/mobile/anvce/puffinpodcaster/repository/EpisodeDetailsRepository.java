package com.mobile.anvce.puffinpodcaster.repository;

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

public class EpisodeDetailsRepository extends BasePodcastsRepository implements PuffinPodcasterConstants {

	private static final String TAG = EpisodeDetailsRepository.class.getSimpleName();
	private PuffinPodcastsDao podcastDao;

	public EpisodeDetailsRepository(@NonNull Context context) {
		super(context);
		podcastDao = AppDatabase.getInstance(context.getApplicationContext()).podcastsDao();
	}

	public void saveEpisodeToFavoriteList(Episode episodeItem) {

		final DbEpisode dbEpisode = new DbEpisodeFromEpisode().transform(episodeItem);
		dbEpisode.setCategory(PLAY_LIST);

		AppExecutors.getInstance().diskIO().execute(() -> {
			final DbEpisode retrievedRecord = podcastDao.retrieveEpisodeById(episodeItem.getId());
			if (retrievedRecord != null && PLAY_LIST.equals(retrievedRecord.getCategory())) {
				Log.d(TAG, "Updated Episode Play List/ Favorite option");
				podcastDao.updateEpisode(retrievedRecord);
			} else {
				Log.d(TAG, "Inserting  Episode favorite option");
				podcastDao.insertEpisode(dbEpisode);
			}
		});

	}

	public void saveEpisodeToPlayLaterList(Episode episodeItem) {
		final DbEpisode dbEpisode = new DbEpisodeFromEpisode().transform(episodeItem);
		dbEpisode.setCategory(PLAY_LATER);
		AppExecutors.getInstance().diskIO().execute(() -> {
			final DbEpisode retrievedRecord = podcastDao.retrieveEpisodeById(episodeItem.getId());
			if (retrievedRecord != null && PLAY_LATER.equals(retrievedRecord.getCategory())) {
				Log.d(TAG, "Updated Episode Play Later option");
				podcastDao.updateEpisode(retrievedRecord);
			} else {
				Log.d(TAG, "Inserting  Episode favorite option");
				podcastDao.insertEpisode(dbEpisode);
			}
		});
	}
}
