package com.mobile.anvce.puffinpodcaster.sync;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

import android.os.AsyncTask;
import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.mobile.anvce.puffinpodcaster.backgroundtasks.SyncPuffinPodcastsDataAsyncTask;

import androidx.annotation.NonNull;

public class PodcastsFirebaseJobService extends JobService {

	private static final String TAG = PodcastsFirebaseJobService.class.getSimpleName();
	private AsyncTask<Void, Void, Void> mPodcastsTask;

	@Override
	public boolean onStartJob(@NonNull JobParameters job) {
		String timeStampString = DateFormat.getDateTimeInstance().format(new Date());
		Log.d(TAG, "Sync Job started  @ " + timeStampString);
		mPodcastsTask = new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... voids) {
				new SyncPuffinPodcastsDataAsyncTask(getApplicationContext()).executeOnExecutor(Executors.newSingleThreadExecutor());
				return null;
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				jobFinished(job, false);
			}
		};

		mPodcastsTask.execute();
		return true;
	}

	@Override
	public boolean onStopJob(@NonNull JobParameters job) {
		String timeStampString = DateFormat.getDateTimeInstance().format(new Date());
		Log.d(TAG, String.format("Sync Job Stopped %s at %s", job, timeStampString));
		if (mPodcastsTask != null) {
			mPodcastsTask.cancel(true);
		}
		return true;
	}
}
