package com.mobile.anvce.puffinpodcaster.ui.explore;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.repository.CuratedPodcastsRepository;

import java.util.List;

public class RecommendedFragmentViewModel extends AndroidViewModel {

    private final CuratedPodcastsRepository curatedPodcastsRepository;

    public RecommendedFragmentViewModel(@NonNull Application application) {
        super(application);
        curatedPodcastsRepository = new CuratedPodcastsRepository(application.getApplicationContext());
    }


    public MutableLiveData<List<CuratedList>> getRecommendedPodcastList() {
        return curatedPodcastsRepository.getMutableLiveData();
    }
}
