package com.mobile.anvce.puffinpodcaster.backgroundtasks;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.repository.CuratedPodcastsRepository;

public class UpdateCuratedPodcastsTask extends AsyncTask<Void, Void, List<CuratedList>> {

	private final CuratedPodcastsRepository curatedPodcastsRepository;
	private final String TAG = this.getClass().getSimpleName();

	public UpdateCuratedPodcastsTask(Context context) {
		curatedPodcastsRepository = new CuratedPodcastsRepository(context);
	}

	@Override
	protected List<CuratedList> doInBackground(Void... voids) {
		return curatedPodcastsRepository.getAllCuratedPodcasts();
	}

	@Override
	protected void onPostExecute(List<CuratedList> cuartedList) {
		super.onPostExecute(cuartedList);
		Log.d(TAG, "Updation of Curated Podcasts task done! " + cuartedList.size() + " curated podcasts  downloaded");
	}
}
