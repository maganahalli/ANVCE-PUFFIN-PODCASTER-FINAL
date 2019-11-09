package com.mobile.anvce.puffinpodcaster.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

	private final MutableLiveData<Boolean> selected = new MutableLiveData<Boolean>();

	public void select(Boolean item) {
		selected.setValue(item);
	}

	public LiveData<Boolean> getSelected() {
		return selected;
	}

}
