package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.DownloadedPodcast;
import com.mobile.anvce.puffinpodcaster.database.AppDatabase;
import com.mobile.anvce.puffinpodcaster.database.PuffinPodcastsDao;
import com.mobile.anvce.puffinpodcaster.executors.AppExecutors;
import com.mobile.anvce.puffinpodcaster.transformers.DownloadedPodcastFromDbCuratedPodcast;
import com.mobile.anvce.puffinpodcaster.transformers.DownloadedPodcastFromDbPodcast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class DownloadedPodcastsRepository extends BasePodcastsRepository {

	private static final String TAG = DownloadedPodcastsRepository.class.getSimpleName();
	private PuffinPodcastsDao podcastDao;
	private List<DownloadedPodcast> downloadedPodcasts = new ArrayList<>();

	private MutableLiveData<List<DownloadedPodcast>> mutableLiveData = new MutableLiveData<>();

	public DownloadedPodcastsRepository(@NonNull Context context) {
		super(context);
		podcastDao = AppDatabase.getInstance(context.getApplicationContext()).podcastsDao();
		Log.d(TAG, "Actively getting data from Database");
	}

	public MutableLiveData<List<DownloadedPodcast>> getMutableLiveData() {
		AppExecutors.getInstance().diskIO().execute(() -> {
			downloadedPodcasts.clear();
			downloadedPodcasts.addAll(new DownloadedPodcastFromDbPodcast().transformAll(podcastDao.fetchAllPodcasts()));
			downloadedPodcasts.addAll(new DownloadedPodcastFromDbCuratedPodcast().transformAll(podcastDao.fetchAllCuratedPodcast()));
			AppExecutors.getInstance().mainThread().execute(new Runnable() {
				@Override
				public void run() {
					mutableLiveData.setValue(downloadedPodcasts);
				}
			});

		});
		return mutableLiveData;
	}

}
