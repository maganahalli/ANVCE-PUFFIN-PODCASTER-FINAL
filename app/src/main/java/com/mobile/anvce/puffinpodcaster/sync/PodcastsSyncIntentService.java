package com.mobile.anvce.puffinpodcaster.sync;

import java.util.concurrent.Executors;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.backgroundtasks.SyncPuffinPodcastsDataAsyncTask;

import androidx.annotation.Nullable;

public class PodcastsSyncIntentService extends IntentService {

	private static final String TAG = PodcastsSyncIntentService.class.getSimpleName();

	public PodcastsSyncIntentService() {
		super("PodcastsSyncIntentService");
	}

	@Override
	protected void onHandleIntent(@Nullable Intent intent) {
		Log.d(TAG, "PodcastSyncIntentService started");
		new SyncPuffinPodcastsDataAsyncTask(getApplicationContext()).executeOnExecutor(Executors.newSingleThreadExecutor());
	}
}
