package com.mobile.anvce.puffinpodcaster.ui.explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.adapters.ViewPagerAdapter;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentExploreBinding;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.ui.search.SearchableActivity;

public class ExploreFragment extends Fragment implements PuffinPodcasterConstants {

    FragmentExploreBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		binding =DataBindingUtil.inflate(inflater, R.layout.fragment_explore, container, false);
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
		viewPagerAdapter.addFragment(new PopularFragment(), POPULAR);
		viewPagerAdapter.addFragment(new RecommendedFragment(), RECOMMENDED);
		viewPagerAdapter.addFragment(new BrowseFragment(), BROWSE);
		binding.viewPager.setAdapter(viewPagerAdapter);
		binding.exploreTabs.setupWithViewPager(binding.viewPager);
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