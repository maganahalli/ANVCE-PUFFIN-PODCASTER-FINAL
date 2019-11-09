package com.mobile.anvce.puffinpodcaster.backgroundtasks;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.repository.PopularPodcastsRepository;

public class UpdatePopularPodcastsTask extends AsyncTask<Void, Void, List<Podcast>> {

	private final PopularPodcastsRepository popularPodcastsRepository;
	private final String TAG = this.getClass().getSimpleName();

	public UpdatePopularPodcastsTask(Context context) {
		popularPodcastsRepository = new PopularPodcastsRepository(context);
	}

	@Override
	protected List<Podcast> doInBackground(Void... voids) {
		return popularPodcastsRepository.getAllPopularPodcasts();
	}

	@Override
	protected void onPostExecute(List<Podcast> podcasts) {
		super.onPostExecute(podcasts);
		Log.d(TAG, "Updation of Popular Podcasts task done! " + podcasts.size() + " podcasts downloaded");
	}
}
