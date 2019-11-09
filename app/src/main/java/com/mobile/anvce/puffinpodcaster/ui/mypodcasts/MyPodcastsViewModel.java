package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import com.mobile.anvce.puffinpodcaster.adapters.ViewPagerAdapter;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.PagerAdapter;

public class MyPodcastsViewModel extends BaseObservable implements PuffinPodcasterConstants {

	private MutableLiveData<String> mText;

	private ViewPagerAdapter adapter;
	private FragmentManager mContext;

	public MyPodcastsViewModel(FragmentManager context) {
		mContext = context;
		mText = new MutableLiveData<>();
		mText.setValue("This is mypodcasts fragment");
		//buildPageAdapter();
	}

	public void buildPageAdapter() {
		createViewPager();
	}

	@Bindable
	public PagerAdapter getPagerAdapter() {
		return adapter;
	}

	private void createViewPager() {
		adapter = new ViewPagerAdapter(mContext);
		adapter.addFragment(new LatestFragment(), LATEST);
		adapter.addFragment(new PlayListFragment(), PLAY_LIST);
		adapter.addFragment(new PlayLaterFragment(), PLAY_LATER);
		notifyPropertyChanged(com.mobile.anvce.puffinpodcaster.BR.pagerAdapter);
	}

	public LiveData<String> getText() {
		return mText;
	}
}