package com.mobile.anvce.puffinpodcaster.ui;

import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.GlideApp;

import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

public class BindingUtil {

	@BindingAdapter({"setupWithViewPager"})
	public static void setupWithViewPager(final TabLayout tabLayout, ViewPager viewPager) {
		viewPager.addOnAdapterChangeListener((viewPager1, oldAdapter, newAdapter) -> {
			if (oldAdapter == null && newAdapter == null) {
				return;
			}
			Log.i("TAG", "onAdapterChanged");
			tabLayout.setupWithViewPager(viewPager1);
		});
	}

	@BindingAdapter({"thumbnail"})
	public static void loadImage(ImageView imageView, String imageURL) {
		GlideApp.with(imageView.getContext())
				.load(imageURL)
				.placeholder(R.drawable.ic_broken_image_black_80dp)
				.error(R.drawable.ic_broken_image_black_80dp)
				.into(imageView);
	}

	@BindingAdapter({"customthumbnail"})
	public static void loadCustomImage(DynamicHeightNetworkImageView customImageView, String imageURL) {
		GlideApp.with(customImageView.getContext())
				.load(imageURL)
				.placeholder(R.drawable.ic_broken_image_black_80dp)
				.error(R.drawable.ic_broken_image_black_80dp)
				.override(320, 210)
				.into(customImageView);
	}

}


