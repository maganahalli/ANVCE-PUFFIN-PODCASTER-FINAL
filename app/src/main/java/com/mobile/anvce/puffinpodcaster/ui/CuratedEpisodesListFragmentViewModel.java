package com.mobile.anvce.puffinpodcaster.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.repository.CuratedPodcastEpisodesRepository;
import com.mobile.anvce.puffinpodcaster.repository.PodcastEpisodesRepository;

import java.util.List;

public class CuratedEpisodesListFragmentViewModel extends AndroidViewModel {

    private final CuratedPodcastEpisodesRepository podcastEpisodesRepository;

    public CuratedEpisodesListFragmentViewModel(@NonNull Application application) {
        super(application);
        podcastEpisodesRepository = new CuratedPodcastEpisodesRepository(application.getApplicationContext());
    }

    public LiveData<List<Episode>> getEpisodesList(CuratedPodcast searchItem) {
         return  podcastEpisodesRepository.getMutableLiveData(searchItem);
    }
}
