package com.mobile.anvce.puffinpodcaster.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentProfileBinding;
import com.mobile.anvce.puffinpodcaster.ui.profile.downloaded.DownloadedActivity;
import com.mobile.anvce.puffinpodcaster.ui.profile.feedback.FeedbackActivity;
import com.mobile.anvce.puffinpodcaster.ui.profile.history.ListeningHistoryActivity;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

	public View onCreateView(@NonNull LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		FragmentProfileBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
		binding.shareAppLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT,
						"Hey check out my app at: https://play.google.com/store/apps/details?id=com.mobile.anvce.puffinpodcaster");
				sendIntent.setType("text/plain");
				startActivity(sendIntent);
			}
		});

		binding.feedbackLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent feedbackIntent = new Intent(getActivity(), FeedbackActivity.class);
				startActivity(feedbackIntent);
			}
		});

		binding.downloadedLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent downloadedPodcastIntent = new Intent(getActivity(), DownloadedActivity.class);
				startActivity(downloadedPodcastIntent);
			}
		});

		binding.historyLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent historyIntent = new Intent(getActivity(), ListeningHistoryActivity.class);
				startActivity(historyIntent);
			}
		});
		return binding.getRoot();
	}
}