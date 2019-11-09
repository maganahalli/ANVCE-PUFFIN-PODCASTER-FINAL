package com.mobile.anvce.puffinpodcaster.ui.profile.history;

import android.os.Bundle;

import com.mobile.anvce.puffinpodcaster.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Landing Activity to manage Podcasts discovery and listing.
 */
public class ListeningHistoryActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listening_history);
		setTitle(getString(R.string.listening_history_title));
	}
}
