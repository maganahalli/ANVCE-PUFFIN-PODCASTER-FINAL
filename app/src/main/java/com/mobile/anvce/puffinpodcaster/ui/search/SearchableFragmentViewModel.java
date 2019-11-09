package com.mobile.anvce.puffinpodcaster.ui.search;

import java.util.List;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.repository.SearchByKeywordRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class SearchableFragmentViewModel extends AndroidViewModel {

	private final SearchByKeywordRepository searchByKeywordRepository;

	public SearchableFragmentViewModel(@NonNull Application application) {
		super(application);
		searchByKeywordRepository = new SearchByKeywordRepository(application.getApplicationContext());
	}

	public MutableLiveData<List<SearchResultByKeyWord>> getPodcastList(PodcastSearchItem searchItem) {
		return searchByKeywordRepository.getMutableLiveData(searchItem);
	}
}
