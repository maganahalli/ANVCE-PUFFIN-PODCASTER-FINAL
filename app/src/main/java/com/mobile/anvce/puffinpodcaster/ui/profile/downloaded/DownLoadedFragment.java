package com.mobile.anvce.puffinpodcaster.ui.profile.downloaded;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.DownloadedPodcast;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentDownloadedBinding;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.DownloadedPodcastAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class DownLoadedFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private FragmentDownloadedBinding binding;
	private DownloadedViewModel fragmentViewModel;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_downloaded, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, false);
		initializeRecyclerView(binding.downloadedPodcasts, ONE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.downloadedPodcasts);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentViewModel = ViewModelProviders.of(this).get(DownloadedViewModel.class);
		getDownloadedPodcasts();
	}

	private void getDownloadedPodcasts() {
		fragmentViewModel.getMutableLiveData().observe(this, new Observer<List<DownloadedPodcast>>() {
			@Override
			public void onChanged(List<DownloadedPodcast> downloadedPodcasts) {
				if (!downloadedPodcasts.isEmpty()) {
					DownloadedPodcastAdapter adapter = new DownloadedPodcastAdapter(downloadedPodcasts);
					if (binding.downloadedPodcasts != null) {
						binding.downloadedPodcasts.setAdapter(adapter);
					}
				}

			}
		});
	}
}