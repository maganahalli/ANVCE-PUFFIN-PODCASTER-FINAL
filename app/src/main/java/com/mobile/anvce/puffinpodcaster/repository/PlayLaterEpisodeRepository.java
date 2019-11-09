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

public class PlayLaterEpisodeRepository extends BasePodcastsRepository implements PuffinPodcasterConstants {

	private static final String TAG = PlayLaterEpisodeRepository.class.getSimpleName();
	private PuffinPodcastsDao podcastDao;
	private final LiveData<List<DbEpisode>> dbEpisodeList;

	public final LiveData<List<DbEpisode>> getDbEpisodeList() {
		return dbEpisodeList;
	}

	public PlayLaterEpisodeRepository(@NonNull Context context) {
		super(context);
		podcastDao = AppDatabase.getInstance(context.getApplicationContext()).podcastsDao();
		dbEpisodeList = podcastDao.loadAllPlayLaterEpisodes(PLAY_LATER);
		Log.d(TAG, "Actively retrieving tha Episode list from Database");
	}


	public void deleteEpisodeFromPlayLaterList(@NonNull Episode episodeItem){
		final DbEpisode dbEpisode = new DbEpisodeFromEpisode().transform(episodeItem);
		dbEpisode.setCategory(PLAY_LATER);

		AppExecutors.getInstance().diskIO().execute(() -> {
			final DbEpisode retrievedRecord = podcastDao.retrieveEpisodeById(episodeItem.getId());
			if (retrievedRecord != null && PLAY_LATER.equals(retrievedRecord.getCategory())) {
				Log.d(TAG, "deleted Episode Play Later option");
				podcastDao.deleteEpisode(retrievedRecord);
			}
		});
	}

}
