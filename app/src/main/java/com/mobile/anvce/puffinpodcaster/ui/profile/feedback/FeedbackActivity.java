package com.mobile.anvce.puffinpodcaster.ui.profile.feedback;

import android.os.Bundle;

import com.mobile.anvce.puffinpodcaster.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Landing Activity to manage Podcasts discovery and listing.
 */
public class FeedbackActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		setTitle(getString(R.string.feedback_form_title));
	}
}
