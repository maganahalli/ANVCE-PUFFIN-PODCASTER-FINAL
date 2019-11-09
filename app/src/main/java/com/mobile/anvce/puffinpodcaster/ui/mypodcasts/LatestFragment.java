package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentLatestBinding;
import com.mobile.anvce.puffinpodcaster.transformers.EpisodeFromDbEpisode;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.EpisodeListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class LatestFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private boolean mIsRefreshing = false;
	private FragmentLatestBinding binding;
	private LatestViewModel fragmentModel;


	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_latest, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, mIsRefreshing);
		initializeRecyclerView(binding.latestEpisodesRecyclierView, ONE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
     applyRecyclerAnimation(binding.latestEpisodesRecyclierView);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentModel = ViewModelProviders.of(this).get(LatestViewModel.class);
		getEpisodesLists();
	}

	private void getEpisodesLists() {
		fragmentModel.getFavoriteEpisodesList().observe(this, new Observer<List<DbEpisode>>() {
			@Override
			public void onChanged(List<DbEpisode> dbEpisodes) {
				List<Episode> episodes = new EpisodeFromDbEpisode().transformAll(dbEpisodes);
				if (!episodes.isEmpty()) {
					binding.emptyData.setVisibility(View.GONE);
					EpisodeListAdapter adapter = new EpisodeListAdapter(getActivity(), episodes);
					if (binding.latestEpisodesRecyclierView != null) {
						binding.latestEpisodesRecyclierView.setAdapter(adapter);
					}
				}else{
					binding.emptyData.setVisibility(View.VISIBLE);
				}
			}
		});
	}
}
