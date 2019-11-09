package com.mobile.anvce.puffinpodcaster.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.repository.PodcastEpisodesRepository;

import java.util.List;

public class EpisodesListFragmentViewModel extends AndroidViewModel {

    private final PodcastEpisodesRepository podcastEpisodesRepository;

    public EpisodesListFragmentViewModel(@NonNull Application application) {
        super(application);
        podcastEpisodesRepository = new PodcastEpisodesRepository(application.getApplicationContext());
    }

    public LiveData<List<Episode>> getEpisodesList(Podcast searchItem) {
         return  podcastEpisodesRepository.getMutableLiveData(searchItem);
    }
}
