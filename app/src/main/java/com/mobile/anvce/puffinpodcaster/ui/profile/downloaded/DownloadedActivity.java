package com.mobile.anvce.puffinpodcaster.ui.profile.downloaded;

import android.os.Bundle;

import com.mobile.anvce.puffinpodcaster.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Landing Activity to manage Podcasts discovery and listing.
 */
public class DownloadedActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_downloaded);
		setTitle(getString(R.string.downloaded_title));
	}
}
