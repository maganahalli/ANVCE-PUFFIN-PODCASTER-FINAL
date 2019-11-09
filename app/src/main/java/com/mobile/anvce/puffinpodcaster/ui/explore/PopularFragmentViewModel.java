package com.mobile.anvce.puffinpodcaster.ui.explore;

import java.util.List;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.repository.PopularPodcastsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class PopularFragmentViewModel extends AndroidViewModel {

	private final PopularPodcastsRepository popularPodcastsRepository;

	public PopularFragmentViewModel(@NonNull Application application) {
		super(application);
		popularPodcastsRepository = new PopularPodcastsRepository(application.getApplicationContext());
	}

	public MutableLiveData<List<Podcast>> getPodcastList() {
		return popularPodcastsRepository.getMutableLiveData();
	}

}
