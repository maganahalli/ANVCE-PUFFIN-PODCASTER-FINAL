package com.mobile.anvce.puffinpodcaster.ui.search;

import java.util.List;
import java.util.Objects;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentSearchableBinding;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.SearchPodcastByKeyWordAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class SearchableFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private SearchableFragmentViewModel searchableFragmentViewModel;
	private FragmentSearchableBinding binding;
	private boolean mIsRefreshing = false;
	private PodcastSearchItem searchItem;



	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_searchable, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout,mIsRefreshing);
		initializeRecyclerView(binding.searchedRecyclierView,THREE);
		considerExtractingSearchItem();
		return binding.getRoot();
	}

	private void considerExtractingSearchItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getActivity()).getIntent();
		if (intent != null && intent.hasExtra(SEARCH_ITEM_KEY)) {
			searchItem = intent.getParcelableExtra(SEARCH_ITEM_KEY);
		}
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.searchedRecyclierView);
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		searchableFragmentViewModel = ViewModelProviders.of(this).get(SearchableFragmentViewModel.class);
     getPopularPodcastLists(searchItem);

	}


	private void getPopularPodcastLists(PodcastSearchItem searchItem) {
		searchableFragmentViewModel.getPodcastList(searchItem).observe(this, new Observer<List<SearchResultByKeyWord>>() {
			@Override
			public void onChanged(List<SearchResultByKeyWord> podcasts) {
				if(!podcasts.isEmpty()) {
					SearchPodcastByKeyWordAdapter adapter = new SearchPodcastByKeyWordAdapter(getActivity(), podcasts);
					if (binding.searchedRecyclierView != null) {
						binding.searchedRecyclierView.setAdapter(adapter);
					}
				}
			}
		});
	}


}
