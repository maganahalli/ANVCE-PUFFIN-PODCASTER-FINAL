package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.SearchResult;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchByKeywordRepository extends BasePodcastsRepository {

	private static final String TAG = SearchByKeywordRepository.class.getSimpleName();
	private ArrayList<SearchResultByKeyWord> searchPodcastList = new ArrayList<>();
	private MutableLiveData<List<SearchResultByKeyWord>> mutableLiveData = new MutableLiveData<>();

	public SearchByKeywordRepository(@NonNull Context context) {
		super(context);
	}

	public MutableLiveData<List<SearchResultByKeyWord>> getMutableLiveData(final PodcastSearchItem searchItem) {
		if (searchItem == null) {
			return mutableLiveData;
		}
		if (!searchItem.isFreeformSearch()) {
			searchPodcastList.clear();
			searchPodcastList.addAll(restoreSearchResultistSharedPreference(searchItem.getKeyword()));
			if (!searchPodcastList.isEmpty()) {
				mutableLiveData.setValue(searchPodcastList);
				return mutableLiveData;
			}
		}
		downLoadPodcastsBySerachKey(searchItem);
		return mutableLiveData;
	}

	private void downLoadPodcastsBySerachKey(final PodcastSearchItem searchItem) {
		Call<SearchResult> serachPodcastList = service.getSearchResults(searchItem.getKeyword(), 0, PuffinPodcasterConstants.PODCAST, 0, 10, 30, "68,82", 0, 0, searchItem.getKeyword(), "English", 1);
		serachPodcastList.enqueue(new Callback<SearchResult>() {
			@Override
			public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
				if (response.isSuccessful()) {
					searchPodcastList.clear();
					searchPodcastList.addAll(response.body().getResults());
					if (!searchItem.isFreeformSearch()) {
						persistSearchResultDataToSharedPreference(searchItem.getKeyword(), new PodcastCustomDataConverter().fromSearchList(searchPodcastList));
					}
					mutableLiveData.setValue(searchPodcastList);
					Log.d(TAG, "Success downloading free form keyword  Podcasts");
				}
			}

			@Override
			public void onFailure(Call<SearchResult> call, Throwable t) {
				mutableLiveData.setValue(searchPodcastList);
				Log.d(TAG, "Failure downloading free form keyword  Podcasts");
			}
		});
	}

}
