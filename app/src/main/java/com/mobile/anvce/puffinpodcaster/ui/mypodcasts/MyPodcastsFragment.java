package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.adapters.ViewPagerAdapter;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentMypodcastsLatestBinding;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.ui.search.SearchableActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class MyPodcastsFragment extends Fragment implements PuffinPodcasterConstants {

	//FragmentMypodcastsBinding myPodcastsViewModel;
	FragmentMypodcastsLatestBinding binding;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypodcasts_latest, container, false);
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
		viewPagerAdapter.addFragment(new LatestFragment(), LATEST);
		viewPagerAdapter.addFragment(new PlayListFragment(), PLAY_LIST);
		viewPagerAdapter.addFragment(new PlayLaterFragment(), PLAY_LATER);
		binding.viewPager.setAdapter(viewPagerAdapter);
		binding.podcastsTabs.setupWithViewPager(binding.viewPager);
		binding.subHeader.audioBookLink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PodcastSearchItem searchQuery = new PodcastSearchItem(getString(R.string.audio_books), getString(R.string.audio_books),false);
				Intent intent = new Intent(getContext(), SearchableActivity.class);
				intent.putExtra(SEARCH_ITEM_KEY, searchQuery);
				startActivity(intent);
			}
		});
		return binding.getRoot();
	}


}