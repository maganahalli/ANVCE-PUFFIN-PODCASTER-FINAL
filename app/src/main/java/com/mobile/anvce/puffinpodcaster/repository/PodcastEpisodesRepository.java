package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.EpisodeListResponse;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PodcastEpisodesRepository extends BasePodcastsRepository implements PodcastConstatnts {

	private static final String TAG = PodcastEpisodesRepository.class.getSimpleName();
	private List<Episode> episodeList = new ArrayList();
	private MutableLiveData<List<Episode>> mutableLiveData = new MutableLiveData<>();

	public PodcastEpisodesRepository(@NonNull Context context) {
		super(context);
	}

	public MutableLiveData<List<Episode>> getMutableLiveData(Podcast podcastItem) {
		episodeList.clear();
		downloadEpisodeList(podcastItem);
		return mutableLiveData;
	}

	public MutableLiveData<List<Episode>> getMutableLiveData(SearchResultByKeyWord podcastItem) {
		episodeList.clear();
		downloadEpisodeList(podcastItem);
		return mutableLiveData;
	}

	private void downloadEpisodeList(Podcast podcastItem) {
		Call<EpisodeListResponse> curatedPodcastList = service.getEpisodeList(podcastItem.getId(), SORT_ORDER_OLDEST_FIRST);
		curatedPodcastList.enqueue(new Callback<EpisodeListResponse>() {
			@Override
			public void onResponse(Call<EpisodeListResponse> call, Response<EpisodeListResponse> response) {
				if (response.isSuccessful()) {
					episodeList.addAll(response.body().getEpisodes());
					mutableLiveData.setValue(episodeList);
					Log.d(TAG, "Success downloading Podcasts Episode");
				}
			}

			@Override
			public void onFailure(Call<EpisodeListResponse> call, Throwable t) {
				mutableLiveData.setValue(episodeList);
				Log.d(TAG, "Failure downloading Podcasts Episode");
			}
		});
	}

	private void downloadEpisodeList(SearchResultByKeyWord podcastItem) {
		Call<EpisodeListResponse> curatedPodcastList = service.getEpisodeList(podcastItem.getId(), SORT_ORDER_OLDEST_FIRST);
		curatedPodcastList.enqueue(new Callback<EpisodeListResponse>() {
			@Override
			public void onResponse(Call<EpisodeListResponse> call, Response<EpisodeListResponse> response) {
				if (response.isSuccessful()) {
					episodeList.addAll(response.body().getEpisodes());
					mutableLiveData.setValue(episodeList);
				}
			}

			@Override
			public void onFailure(Call<EpisodeListResponse> call, Throwable t) {
				mutableLiveData.setValue(episodeList);
			}
		});
	}

}
