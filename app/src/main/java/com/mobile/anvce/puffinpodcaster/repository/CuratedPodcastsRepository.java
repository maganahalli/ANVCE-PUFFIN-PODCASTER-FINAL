package com.mobile.anvce.puffinpodcaster.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CuratedPodcastsRepository extends BasePodcastsRepository {

	private static final String TAG = CuratedPodcastsRepository.class.getSimpleName();
	private List<CuratedList> curatedLists = new ArrayList();
	private MutableLiveData<List<CuratedList>> mutableLiveData = new MutableLiveData<>();

	public CuratedPodcastsRepository(@NonNull Context context) {
		super(context);
	}

	public List<CuratedList> getAllCuratedPodcasts() {
		downloadCuratedPodcastList();
		return curatedLists;
	}

	public MutableLiveData<List<CuratedList>> getMutableLiveData() {

		curatedLists = restoreCuratedListSharedPreference();
		if (!curatedLists.isEmpty()) {
			mutableLiveData.setValue(curatedLists);
			return mutableLiveData;
		}
		downloadCuratedPodcastList();
		return mutableLiveData;
	}

	private void downloadCuratedPodcastList() {
		Call<CuratedPodcastServiceResponse> curatedPodcastList = service.getCuratedPodcastList("2");
		curatedPodcastList.enqueue(new Callback<CuratedPodcastServiceResponse>() {
			@Override
			public void onResponse(Call<CuratedPodcastServiceResponse> call, Response<CuratedPodcastServiceResponse> response) {
				if (response.isSuccessful()) {
					curatedLists.addAll(response.body().getCuratedLists());
					saveCuratedPodcastListToSharedPrefrences(new PodcastCustomDataConverter().fromCuratedtList(curatedLists));
					persistCuratedListDataToDatabase(curatedLists);
					mutableLiveData.setValue(curatedLists);
					Log.d(TAG, "Success downloading Curated Lists");
				}
			}

			@Override
			public void onFailure(Call<CuratedPodcastServiceResponse> call, Throwable t) {
				curatedLists.addAll(buildCuratedList(""));
				persistCuratedListDataToDatabase(curatedLists);
				mutableLiveData.setValue(curatedLists);
				Log.d(TAG, "Failure downloading Curated Lists");
			}
		});
	}

}
