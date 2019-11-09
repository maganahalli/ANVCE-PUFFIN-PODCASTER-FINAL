package com.mobile.anvce.puffinpodcaster.ui.profile.feedback;

import java.util.Objects;
import java.util.UUID;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.mobile.anvce.puffinpodcaster.BuildConfig;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.custom.PodcastTextWatcher;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment implements PuffinPodcasterConstants {

	private EditText nameDataView;
	private EditText emailDataView;
	private EditText messageDataView;
	private Button feedbackSubmitButton;
	private Firebase firebase;

	public View onCreateView(@NonNull LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_feedback, container, false);
		initializeViews(root);
		return root;
	}

	private void initializeViews(View root) {
		initializeName(root);
		initializeEmail(root);
		initializeMessage(root);
		feedbackSubmitButton = root.findViewById(R.id.feedbackSubmitButton);
		Firebase.setAndroidContext(Objects.requireNonNull(getActivity()));
		String uniqueId = UUID.randomUUID().toString();
		firebase = new Firebase(BuildConfig.FIREBASE_FEEDBACK_URL_KEY + uniqueId);
		feedbackSubmitButton.setOnClickListener(v -> sendFeedback());

	}

	private void initializeMessage(View root) {
		messageDataView = root.findViewById(R.id.messageData);
		messageDataView.addTextChangedListener(new PodcastTextWatcher() {
      @Override
			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
				feedbackSubmitButton.setEnabled(true);
			}
		});
	}

	private void initializeEmail(View root) {
		emailDataView = root.findViewById(R.id.emailData);
		emailDataView.addTextChangedListener(new PodcastTextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
				feedbackSubmitButton.setEnabled(true);
			}
		});
	}

	private void initializeName(View root) {
		nameDataView = root.findViewById(R.id.nameData);
		nameDataView.addTextChangedListener(new PodcastTextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
				feedbackSubmitButton.setEnabled(true);
			}
		});
	}

	private void sendFeedback() {
		final String name = nameDataView.getText().toString();
		final String email = emailDataView.getText().toString();
		final String message = messageDataView.getText().toString();

		Firebase childName = firebase.child(getString(R.string.name));
		childName.setValue(name);
		validateInputAndSendFeedback(name, nameDataView);

		Firebase childEmail = firebase.child(getString(R.string.email));
		childEmail.setValue(email);
		validateInputAndSendFeedback(email, emailDataView);

		Firebase childMessage = firebase.child(getString(R.string.message));
		childMessage.setValue(message);
		validateInputAndSendFeedback(message, messageDataView);

		if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(message)) {
			Objects.requireNonNull(getActivity()).finish();
		}
	}

	private void validateInputAndSendFeedback(String input, EditText userEnteredView) {
		if (TextUtils.isEmpty(input)) {
			userEnteredView.setError(PuffinPodcasterConstants.THIS_IS_REQUIRED_FIELD);
			feedbackSubmitButton.setEnabled(false);
		} else {
			userEnteredView.setError(null);
			feedbackSubmitButton.setEnabled(true);
		}
	}

}