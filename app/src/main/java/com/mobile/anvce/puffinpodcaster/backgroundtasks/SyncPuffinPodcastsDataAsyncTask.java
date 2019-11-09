package com.mobile.anvce.puffinpodcaster.backgroundtasks;

import java.util.concurrent.Executors;

import android.content.Context;
import android.os.AsyncTask;

public class SyncPuffinPodcastsDataAsyncTask extends AsyncTask<Void, Void, Void> {

	private final Context context;

	public SyncPuffinPodcastsDataAsyncTask(Context context) {
		this.context = context;
	}

	@Override
	protected Void doInBackground(Void... voids) {
		updatePodcastsData();
		return null;
	}

	private void updatePodcastsData() {
		new UpdatePopularPodcastsTask(context).executeOnExecutor(Executors.newSingleThreadExecutor());
		new UpdateCuratedPodcastsTask(context).executeOnExecutor(Executors.newSingleThreadExecutor());
	}
}
