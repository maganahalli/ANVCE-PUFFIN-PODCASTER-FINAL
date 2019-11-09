package com.mobile.anvce.puffinpodcaster.ui.explore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItemBuilder;

import java.util.ArrayList;
import java.util.List;

public class BrowseViewModel extends ViewModel {

	private MutableLiveData<List<PodcastSearchItem>> categoryList;

	public BrowseViewModel() {
		categoryList = new MutableLiveData<>();
		categoryList.setValue(buildBrowsePodcastsByCategory());
	}

	public List<PodcastSearchItem> buildBrowsePodcastsByCategory() {
		List<PodcastSearchItem> categories = new ArrayList<>();
		categories.add(new PodcastSearchItemBuilder(1, "Arts", "Arts Category", R.drawable.ic_arts_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(2, "Business", "Business Category", R.drawable.ic_handshake).build());
		categories.add(new PodcastSearchItemBuilder(3, "Comedy", "Comedy Category", R.drawable.ic_comedy).build());
		categories.add(new PodcastSearchItemBuilder(4, "Education", "Education Category", R.drawable.ic_school_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(5, "Games & Hobbies", "Games & Hobbies Category", R.drawable.ic_golf_course_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(6, "Government & Organizations", "Government & Organizations Category", R.drawable.ic_location_city_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(7, "Health", "Health Category", R.drawable.ic_local_hospital_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(8, "Kids & Family", "Kids & Family Category", R.drawable.ic_child_care_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(9, "Music", "Music Category", R.drawable.ic_music_note_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(10, "News & Politics", "News & Politics Category", R.drawable.ic_public_black_24dp).build());
		categories.add(new PodcastSearchItemBuilder(11, "Religion & Spirituality", "Religion & Spirituality Category", R.drawable.ic_religion).build());
		categories.add(new PodcastSearchItemBuilder(12, "Society & Culture", "Society & Culture Category", R.drawable.ic_society).build());
		categories.add(new PodcastSearchItemBuilder(13, "Science & Medicine", "Science & Medicine Category", R.drawable.ic_microscope).build());
		categories.add(new PodcastSearchItemBuilder(14, "Technology", "Technology Category", R.drawable.ic_artificial_intelligence).build());
		categories.add(new PodcastSearchItemBuilder(15, "TV & Film", "TV & Film Category", R.drawable.ic_tv_black_24dp).build());
		return categories;
	}
}
