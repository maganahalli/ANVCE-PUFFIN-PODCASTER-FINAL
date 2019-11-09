package com.mobile.anvce.puffinpodcaster.ui.preferences;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PreferencesViewModel extends ViewModel {

	private MutableLiveData<String> mText;
  private MutableLiveData<List<String>> mRegion;

	public PreferencesViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is preferences fragment");
		mRegion = new MutableLiveData<>();
		mRegion.setValue(buildRegionList());
	}

	public List<String> buildRegionList() {
		// Spinner Drop down elements
		List<String> regions = new ArrayList<String>();
		regions.add("USA");
		regions.add("Australia");
		regions.add("Canada");
		regions.add("China");
		regions.add("India");
		regions.add("Israel");
		regions.add("Italy");
		regions.add("Ireland");
		regions.add("Jamaica");
		regions.add("Japan");
		regions.add("Lithuania");
		regions.add("Qatar");
		regions.add("Singapore");
		regions.add("South Africa");
		regions.add("Sweden");
		regions.add("Vietnam");
		return regions;
	}

	public LiveData<String> getText() {
		return mText;
	}

	public LiveData<List<String>> getRegionList(){
		return mRegion;
	}
}