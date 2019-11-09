package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.api.model.PodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.util.NotificationUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularPodcastsRepository extends BasePodcastsRepository {

	private static final String GENRE_ID = "93";
	private static final String PAGE = "2";
	private static final String SAFE_MODE = "1";
	private static final String TAG = PopularPodcastsRepository.class.getSimpleName();

	public List<Podcast> getAllPopularPodcasts() {
		downLoadPopularPodcasts();
		return podcastList;
	}

	private ArrayList<Podcast> podcastList = new ArrayList<>();
	private MutableLiveData<List<Podcast>> mutableLiveData = new MutableLiveData<>();
	private Context context;

	public PopularPodcastsRepository(@NonNull Context context) {
		super(context);
		this.context = context;
	}

	public MutableLiveData<List<Podcast>> getMutableLiveData() {

		podcastList = restorePopularPodcastSharedPreference();
		if (!podcastList.isEmpty()) {
			mutableLiveData.setValue(podcastList);
			return mutableLiveData;
		}
		downLoadPopularPodcasts();
		return mutableLiveData;
	}

	private void downLoadPopularPodcasts() {
		Call<PodcastServiceResponse> downloadBestPodcastsList = service.getBestPodcastList(GENRE_ID, PAGE, getSupportedRegionCode(), SAFE_MODE);
		downloadBestPodcastsList.enqueue(new Callback<PodcastServiceResponse>() {
			@Override
			public void onResponse(Call<PodcastServiceResponse> call, Response<PodcastServiceResponse> response) {
				if (response.isSuccessful()) {
					podcastList.addAll(response.body().getPodcasts());
					persistPodcastDataToSharedPreference(new PodcastCustomDataConverter().fromPodcastList(podcastList));
					persistPodcastDataToDatabase(podcastList);
					mutableLiveData.setValue(podcastList);
					NotificationUtils.notifyUserOfNewPodcast(context);
					Log.d(TAG, "Success downloading Popular Podcasts");
				}
			}

			@Override
			public void onFailure(Call<PodcastServiceResponse> call, Throwable t) {
				podcastList.addAll(buildPodcastList(""));
				persistPodcastDataToSharedPreference(new PodcastCustomDataConverter().fromPodcastList(podcastList));
				persistPodcastDataToDatabase(podcastList);
				mutableLiveData.setValue(podcastList);
				Log.d(TAG, "Failure downloading Popular Podcasts");
			}
		});
	}
}
