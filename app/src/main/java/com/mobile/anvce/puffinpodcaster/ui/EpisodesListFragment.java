package com.mobile.anvce.puffinpodcaster.ui;

import java.util.List;
import java.util.Objects;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentEpisodesListBinding;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.EpisodeListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class EpisodesListFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private EpisodesListFragmentViewModel fragmentViewModel;
	private FragmentEpisodesListBinding binding;
	private boolean mIsRefreshing = false;
	private Podcast podcastItem;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_episodes_list, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, mIsRefreshing);
		initializeRecyclerView(binding.episodesRecyclierView, ONE);
		considerExtractingPodcastItem();
		return binding.getRoot();
	}

	private void considerExtractingPodcastItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getActivity()).getIntent();
		if (intent != null && intent.hasExtra(PODCAST_ITEM_KEY)) {
			podcastItem = intent.getParcelableExtra(PODCAST_ITEM_KEY);
			binding.setPodcastItem(podcastItem);
		}
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.episodesRecyclierView);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentViewModel = ViewModelProviders.of(this).get(EpisodesListFragmentViewModel.class);
		getEpisodesLists(podcastItem);
	}

	private void getEpisodesLists(Podcast searchItem) {
		fragmentViewModel.getEpisodesList(searchItem).observe(this, new Observer<List<Episode>>() {
			@Override
			public void onChanged(List<Episode> episodes) {
				if (!episodes.isEmpty()) {
					EpisodeListAdapter adapter = new EpisodeListAdapter(getActivity(), episodes);
					if (binding.episodesRecyclierView != null) {
						binding.episodesRecyclierView.setAdapter(adapter);
					}
				}
			}
		});
	}

}
