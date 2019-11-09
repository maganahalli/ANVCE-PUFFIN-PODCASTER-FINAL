package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentPlayLaterBinding;
import com.mobile.anvce.puffinpodcaster.transformers.EpisodeFromDbEpisode;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.PlayLaterEpisodeListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class PlayLaterFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private PlayLaterViewModel fragmentViewModel;
	private FragmentPlayLaterBinding binding;
	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_play_later, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, false);
		initializeRecyclerView(binding.laterEpisodesRecyclierView, ONE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.laterEpisodesRecyclierView);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentViewModel = ViewModelProviders.of(this).get(PlayLaterViewModel.class);
		getEpisodesLists();
	}

	private void getEpisodesLists() {
		fragmentViewModel.getPlayLaterEpisodesList().observe(this, new Observer<List<DbEpisode>>() {
			@Override
			public void onChanged(List<DbEpisode> dbEpisodes) {
				List<Episode> episodes = new EpisodeFromDbEpisode().transformAll(dbEpisodes);
				if (!episodes.isEmpty()) {
					binding.emptyData.setVisibility(View.GONE);
					PlayLaterEpisodeListAdapter adapter = new PlayLaterEpisodeListAdapter(getActivity(), episodes);
					if (binding.laterEpisodesRecyclierView != null) {
						binding.laterEpisodesRecyclierView.setAdapter(adapter);
					}
				}else{
					binding.emptyData.setVisibility(View.VISIBLE);
				}
			}
		});
	}
}
