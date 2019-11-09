package com.mobile.anvce.puffinpodcaster;

import java.util.Objects;

import android.os.Bundle;

import com.mobile.anvce.puffinpodcaster.databinding.ActivityHolderBinding;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public abstract class BaseNavigationActivity extends AppCompatActivity {

	public ActivityHolderBinding navigationBinding;

	private void inflateActivityHolder() {
		navigationBinding = DataBindingUtil.setContentView(this, R.layout.activity_holder);

	}

	@LayoutRes
	protected abstract int getLayoutResourceId();

	private void inflateActivityViewStub() {
		Objects.requireNonNull(navigationBinding.activityContainer.getViewStub()).setLayoutResource(getLayoutResourceId());
		navigationBinding.activityContainer.getViewStub().inflate();
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inflateActivityHolder();
		inflateActivityViewStub();

	}

}
