package com.mobile.anvce.puffinpodcaster.ui.profile.history;

import java.util.List;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.repository.ListeningPodcastsHistoryRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ListeningHistoryViewModel extends AndroidViewModel {

	private ListeningPodcastsHistoryRepository repository;

	public ListeningHistoryViewModel(@NonNull Application application) {
		super(application);
		repository = new ListeningPodcastsHistoryRepository(application);
	}

	public MutableLiveData<List<Episode>> getMutableLiveData() {
		return repository.getMutableLiveData();
	}

}
