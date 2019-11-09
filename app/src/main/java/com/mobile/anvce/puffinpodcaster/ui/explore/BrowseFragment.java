package com.mobile.anvce.puffinpodcaster.ui.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentBrowseBinding;
import com.mobile.anvce.puffinpodcaster.adapters.PodcastSearchByCategoryAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class BrowseFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private FragmentBrowseBinding binding;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_browse, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, false);
		initializeRecyclerView(binding.browsePodcastByCategory, ONE);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.browsePodcastByCategory);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		BrowseViewModel viewModel = ViewModelProviders.of(this).get(BrowseViewModel.class);
		PodcastSearchByCategoryAdapter adapter = new PodcastSearchByCategoryAdapter(getContext(), viewModel.buildBrowsePodcastsByCategory());
		adapter.setHasStableIds(true);
		binding.browsePodcastByCategory.setAdapter(adapter);
	}
}
