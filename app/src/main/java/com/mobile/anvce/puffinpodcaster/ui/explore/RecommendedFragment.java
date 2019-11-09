package com.mobile.anvce.puffinpodcaster.ui.explore;

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
import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentRecommendedBinding;
import com.mobile.anvce.puffinpodcaster.adapters.CuratedListAdapter;

import java.util.List;

public class RecommendedFragment extends BasePodcasterFragment {

	private FragmentRecommendedBinding binding;
	private RecommendedFragmentViewModel recommendedFragmentViewModel;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recommended, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout,false);
		initializeRecyclerView(binding.curatedPodcasts,2);
		return binding.getRoot();
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.curatedPodcasts);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		recommendedFragmentViewModel = ViewModelProviders.of(this).get(RecommendedFragmentViewModel.class);
		getRecommendedPodcastList();
	}

	private void getRecommendedPodcastList() {
		recommendedFragmentViewModel.getRecommendedPodcastList().observe(this, new Observer<List<CuratedList>>() {
			@Override
			public void onChanged(List<CuratedList> curatedLists) {
				if (!curatedLists.isEmpty()) {
					CuratedListAdapter adapter = new CuratedListAdapter(getActivity(), curatedLists);
					if (binding.curatedPodcasts != null) {
						binding.curatedPodcasts.setAdapter(adapter);
					}
				}
			}
		});
	}

}
