package com.mobile.anvce.puffinpodcaster.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentCuratedPodcastListBinding;
import com.mobile.anvce.puffinpodcaster.ui.explore.BasePodcasterFragment;
import com.mobile.anvce.puffinpodcaster.adapters.CuratedPodcastListAdapter;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import java.util.Objects;

public class CuratedPodcastListFragment extends BasePodcasterFragment implements PodcastConstatnts {

	private FragmentCuratedPodcastListBinding binding;
	private boolean mIsRefreshing = false;
	private CuratedList curatedList;

	@Override
	protected View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_curated_podcast_list, container, false);
		setSwipeRefreshLayout(binding.swipeRefreshLayout, mIsRefreshing);
		initializeRecyclerView(binding.curatedPodcastsRecyclierView, TWO);
		considerExtractingPodcastItem();
		return binding.getRoot();
	}

	private void considerExtractingPodcastItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getActivity()).getIntent();
		if (intent != null && intent.hasExtra(CURATED_LIST_ITEM_KEY)) {
			curatedList = intent.getParcelableExtra(CURATED_LIST_ITEM_KEY);
			binding.setCuratedListItem(curatedList);
		}
	}

	@Override
	protected void refreshWithAnimation() {
		applyRecyclerAnimation(binding.curatedPodcastsRecyclierView);
	}


	@Override
	public void onResume() {
		super.onResume();
		getCuratedPodcastList();
	}

	private void getCuratedPodcastList() {

		if (! binding.getCuratedListItem().getPodcasts().isEmpty()) {
			CuratedPodcastListAdapter adapter = new CuratedPodcastListAdapter(getActivity(), binding.getCuratedListItem().getPodcasts());
			if (binding.curatedPodcastsRecyclierView != null) {
				binding.curatedPodcastsRecyclierView.setAdapter(adapter);
			}
		}

	}

}
