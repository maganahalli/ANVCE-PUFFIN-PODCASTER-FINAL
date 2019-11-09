package com.mobile.anvce.puffinpodcaster.ui.explore;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.adapters.PopularPodcastAdapter;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentPopularBinding;
import com.mobile.anvce.puffinpodcaster.util.NotificationUtils;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class PopularFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private PopularFragmentViewModel popularFragmentViewModel;
	private FragmentPopularBinding binding;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, false);
		initializeRecyclerView(binding.popularPodcasts, THREE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.popularPodcasts);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		popularFragmentViewModel = ViewModelProviders.of(this).get(PopularFragmentViewModel.class);
		getPopularPodcastLists();
	}

	private void getPopularPodcastLists() {
		popularFragmentViewModel.getPodcastList().observe(this, new Observer<List<Podcast>>() {
			@Override
			public void onChanged(List<Podcast> podcasts) {
				if (!podcasts.isEmpty()) {
					PopularPodcastAdapter adapter = new PopularPodcastAdapter(getActivity(), podcasts);
					if (binding.popularPodcasts != null) {
						binding.popularPodcasts.setAdapter(adapter);
					}
				}
			}
		});
	}

}
