package com.mobile.anvce.puffinpodcaster.adapters;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ViewPagerAdapter extends SmartFragmentStatePagerAdapter {

	private final List<Fragment> fragmentList = new ArrayList<>();
	private final List<String> fragmentTitleList = new ArrayList<>();

	public ViewPagerAdapter(@NonNull FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

	@NonNull
	@Override
	public Fragment getItem(int position) {
		return fragmentList.get(position);
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return fragmentTitleList.get(position);
	}

	public void addFragment(Fragment fragment, String title) {
		fragmentList.add(fragment);
		fragmentTitleList.add(title);
	}
}
