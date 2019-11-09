package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentFavoriteListBinding;
import com.mobile.anvce.puffinpodcaster.transformers.EpisodeFromDbEpisode;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.PlayFavoriteEpisodeListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class PlayListFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private FragmentFavoriteListBinding binding;
	private PlayListViewModel playListViewModel;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_list, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, false);
		initializeRecyclerView(binding.favoriteEpisodesRecyclierView, ONE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.favoriteEpisodesRecyclierView);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		playListViewModel = ViewModelProviders.of(this).get(PlayListViewModel.class);
		getEpisodesLists();
	}

	private void getEpisodesLists() {
		playListViewModel.getFavoriteEpisodesList().observe(this, new Observer<List<DbEpisode>>() {
			@Override
			public void onChanged(List<DbEpisode> dbEpisodes) {
				List<Episode> episodes = new EpisodeFromDbEpisode().transformAll(dbEpisodes);
				if (!episodes.isEmpty()) {
					binding.emptyData.setVisibility(View.GONE);
					PlayFavoriteEpisodeListAdapter adapter = new PlayFavoriteEpisodeListAdapter(getActivity(), episodes);
					if (binding.favoriteEpisodesRecyclierView != null) {
						binding.favoriteEpisodesRecyclierView.setAdapter(adapter);
					}
				} else {
					binding.emptyData.setVisibility(View.VISIBLE);
				}
			}
		});
	}

}
