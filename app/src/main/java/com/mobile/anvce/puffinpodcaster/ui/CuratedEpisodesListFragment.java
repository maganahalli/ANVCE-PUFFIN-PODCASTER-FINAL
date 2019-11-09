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
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentCuratedEpisodesListBinding;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.EpisodeListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import java.util.List;
import java.util.Objects;

public class CuratedEpisodesListFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private CuratedEpisodesListFragmentViewModel fragmentViewModel;
	private FragmentCuratedEpisodesListBinding binding;
	private boolean mIsRefreshing = false;
	private CuratedPodcast podcastItem;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_curated_episodes_list, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, mIsRefreshing);
		initializeRecyclerView(binding.curatedEpisodesRecyclierView, ONE);
		considerExtractingPodcastItem();
		return binding.getRoot();
	}

	private void considerExtractingPodcastItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getActivity()).getIntent();
		if (intent != null && intent.hasExtra(CURATED_PODCAST_ITEM_KEY)) {
			podcastItem = intent.getParcelableExtra(CURATED_PODCAST_ITEM_KEY);
			binding.setPodcastItem(podcastItem);
		}
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.curatedEpisodesRecyclierView);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentViewModel = ViewModelProviders.of(this).get(CuratedEpisodesListFragmentViewModel.class);
		getEpisodesLists(podcastItem);
	}

	private void getEpisodesLists(CuratedPodcast searchItem) {
		fragmentViewModel.getEpisodesList(searchItem).observe(this, new Observer<List<Episode>>() {
			@Override
			public void onChanged(List<Episode> episodes) {
				if (!episodes.isEmpty()) {
					EpisodeListAdapter adapter = new EpisodeListAdapter(getActivity(), episodes);
					if (binding.curatedEpisodesRecyclierView != null) {
						binding.curatedEpisodesRecyclierView.setAdapter(adapter);
					}
				}
			}
		});
	}

}
