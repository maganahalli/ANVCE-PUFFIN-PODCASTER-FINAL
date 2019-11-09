package com.mobile.anvce.puffinpodcaster.ui.explore;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class ExploreTab extends TabLayout implements PuffinPodcasterConstants {

	public ExploreTab(Context context) {
		super(context);
	}

	public ExploreTab(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ExploreTab(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public void setupWithViewPager(@Nullable ViewPager viewPager) {
		super.setupWithViewPager(viewPager);
		Log.i("TAG", "setupWithViewPager");
		if (viewPager.getAdapter() == null) {
			return;
		}
		createTabIcons();
	}

	private void createTabIcons() {
		Log.i("TAG", "createTabIcons");
		LinearLayout tabOne =
				(LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.explore_tab, null);
		((TextView) tabOne.findViewById(R.id.text_title)).setText(POPULAR);
		this.getTabAt(0).setCustomView(tabOne);

		LinearLayout tabTwo =
				(LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.explore_tab, null);
		((TextView) tabTwo.findViewById(R.id.text_title)).setText(RECOMMENDED);
		this.getTabAt(1).setCustomView(tabTwo);

		LinearLayout tabThree =
				(LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.explore_tab, null);
		((TextView) tabThree.findViewById(R.id.text_title)).setText(BROWSE);
		this.getTabAt(2).setCustomView(tabThree);
	}
}
