package com.mobile.anvce.puffinpodcaster.ui.profile.history;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.adapters.HistoryAdapter;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentListeningHistoryBinding;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class ListeningHistoryFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private FragmentListeningHistoryBinding binding;
	private ListeningHistoryViewModel fragmentViewModel;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listening_history, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, false);
		initializeRecyclerView(binding.listeningHistoryepisodes, ONE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.listeningHistoryepisodes);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentViewModel = ViewModelProviders.of(this).get(ListeningHistoryViewModel.class);
		getDownloadedPodcasts();
	}

	private void getDownloadedPodcasts() {
		fragmentViewModel.getMutableLiveData().observe(this, new Observer<List<Episode>>() {
			@Override
			public void onChanged(List<Episode> episodes) {
				if (!episodes.isEmpty()) {
					HistoryAdapter adapter = new HistoryAdapter(episodes);
					if (binding.listeningHistoryepisodes != null) {
						binding.listeningHistoryepisodes.setAdapter(adapter);
					}
				}

			}
		});
	}
}