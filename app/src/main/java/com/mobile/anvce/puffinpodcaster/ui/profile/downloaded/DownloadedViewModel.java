package com.mobile.anvce.puffinpodcaster.ui.profile.downloaded;

import java.util.List;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.api.model.DownloadedPodcast;
import com.mobile.anvce.puffinpodcaster.repository.DownloadedPodcastsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class DownloadedViewModel extends AndroidViewModel {

	private DownloadedPodcastsRepository repository;

	public DownloadedViewModel(@NonNull Application application) {
		super(application);
		repository = new DownloadedPodcastsRepository(application);
	}

	public MutableLiveData<List<DownloadedPodcast>> getMutableLiveData() {
		return repository.getMutableLiveData();
	}

}
