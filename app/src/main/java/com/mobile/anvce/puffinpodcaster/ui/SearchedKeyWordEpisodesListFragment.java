package com.mobile.anvce.puffinpodcaster.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentSearchedKeywordEpisodesListBinding;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.EpisodeListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import java.util.List;
import java.util.Objects;

public class SearchedKeyWordEpisodesListFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private SearchedKeyWordEpisodesListFragmentViewModel fragmentViewModel;
	private FragmentSearchedKeywordEpisodesListBinding binding;
	private boolean mIsRefreshing = false;
	private SearchResultByKeyWord podcastItem;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_searched_keyword_episodes_list, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, mIsRefreshing);
		initializeRecyclerView(binding.searchedKeyWordEpisodesRecyclierView, ONE);
		considerExtractingPodcastItem();
		return binding.getRoot();
	}

	private void considerExtractingPodcastItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getActivity()).getIntent();
		if (intent != null && intent.hasExtra(SEARCHED_KEY_WORD_ITEM_KEY)) {
			podcastItem = intent.getParcelableExtra(SEARCHED_KEY_WORD_ITEM_KEY);
			binding.setSearchedItem(podcastItem);
		}
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.searchedKeyWordEpisodesRecyclierView);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentViewModel = ViewModelProviders.of(this).get(SearchedKeyWordEpisodesListFragmentViewModel.class);
		getEpisodesLists(podcastItem);
	}

	private void getEpisodesLists(SearchResultByKeyWord searchItem) {
		fragmentViewModel.getEpisodesList(searchItem).observe(this, new Observer<List<Episode>>() {
			@Override
			public void onChanged(List<Episode> episodes) {
				if (!episodes.isEmpty()) {
					EpisodeListAdapter adapter = new EpisodeListAdapter(getActivity(), episodes);
					if (binding.searchedKeyWordEpisodesRecyclierView != null) {
						binding.searchedKeyWordEpisodesRecyclierView.setAdapter(adapter);
					}
				}
			}
		});
	}

}
