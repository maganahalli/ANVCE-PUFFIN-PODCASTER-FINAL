package com.mobile.anvce.puffinpodcaster.ui.details;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.media.session.MediaButtonReceiver;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentEpisodeDetailBinding;
import com.mobile.anvce.puffinpodcaster.databinding.FragmentSearchKeywordDetailBinding;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SearchedKeyWordDetailFragment extends Fragment implements Player.EventListener,PodcastConstatnts {

	private final static String TAG = SearchedKeyWordDetailFragment.class.getSimpleName();
	private FragmentSearchKeywordDetailBinding binding;
	private SearchResultByKeyWord searchedItem;
	private static MediaSessionCompat mMediaSession;
	private boolean isPlayWhenReady;
	private SimpleExoPlayer mExoPlayer;
	private boolean mExoPlayerFullscreen = false;
	private Dialog mFullScreenDialog;
	private NotificationManager mNotificationManager;
	private long mResumePosition;
	private int mResumeWindow;
	private PlaybackStateCompat.Builder mStateBuilder;
	private MediaSource mAudioSource;
	private PlayerView mExoPlayerView;
	private FrameLayout mainMediaFrame;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			mResumeWindow = savedInstanceState.getInt(STATE_RESUME_WINDOW);
			mResumePosition = savedInstanceState.getLong(STATE_RESUME_POSITION);
			mExoPlayerFullscreen = savedInstanceState.getBoolean(STATE_PLAYER_FULLSCREEN);
			isPlayWhenReady = savedInstanceState.getBoolean(PLAY_STATE);
		}
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_keyword_detail, container, false);
		mExoPlayerView = binding.exoplayer;
		mainMediaFrame = binding.mainMediaFrame;
		considerExtractingSearchItem();
		return binding.getRoot();
	}

	private void considerExtractingSearchItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getActivity()).getIntent();
		if (intent != null && intent.hasExtra(SEARCHED_KEY_WORD_ITEM_KEY)) {
			searchedItem = intent.getParcelableExtra(SEARCHED_KEY_WORD_ITEM_KEY);
			binding.setSearchItem(searchedItem);
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		if (TextUtils.isEmpty(searchedItem.getAudio())) {
			return;
		}

		initFullscreenDialog();
		final Uri audioUri = Uri.parse(searchedItem.getAudio());
		// Create a data source factory.
		DataSource.Factory dataSourceFactory =
				new DefaultHttpDataSourceFactory(Util.getUserAgent(getActivity(), getString(R.string.app_name)));
		// Create a progressive media source pointing to a stream uri.
		mAudioSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
				.createMediaSource(audioUri);
		initializeMediaSession();
		initExoPlayer(audioUri);
	}

	private void initExoPlayer(Uri mediaUri) {
		if (mExoPlayer == null) {
			TrackSelector trackSelector = new DefaultTrackSelector();
			mExoPlayer = ExoPlayerFactory.newSimpleInstance(Objects.requireNonNull(getActivity()), trackSelector);
			assert mExoPlayerView != null;
			mExoPlayerView.setPlayer(mExoPlayer);

			// Set the ExoPlayer.EventListener to this activity.
			mExoPlayer.addListener(this);

			boolean haveResumePosition = mResumeWindow != C.INDEX_UNSET;

			if (haveResumePosition) {
				mExoPlayerView.getPlayer().seekTo(mResumeWindow, mResumePosition);
			}

			// Prepare the MediaSource.
			// Create a data source factory.
			DataSource.Factory dataSourceFactory =
					new DefaultHttpDataSourceFactory(Util.getUserAgent(getActivity(), "app-name"));
			// Create a progressive media source pointing to a stream uri.
			mAudioSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
					.createMediaSource(mediaUri);
			mExoPlayer.prepare(mAudioSource);
			mExoPlayer.setPlayWhenReady(isPlayWhenReady);
		}
	}

	/**
	 * Initializes the Media Session to be enabled with media buttons, transport controls, callbacks
	 * and media controller.
	 */
	private void initializeMediaSession() {

		// Create a MediaSessionCompat.
		mMediaSession = new MediaSessionCompat(Objects.requireNonNull(getActivity()), TAG);

		// Enable callbacks from MediaButtons and TransportControls.
		mMediaSession.setFlags(
				MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
						MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);

		// Do not let MediaButtons restart the player when the app is not visible.
		mMediaSession.setMediaButtonReceiver(null);

		// Set an initial PlaybackState with ACTION_PLAY, so media buttons can start the player.
		mStateBuilder = new PlaybackStateCompat.Builder()
				.setActions(
						PlaybackStateCompat.ACTION_PLAY |
								PlaybackStateCompat.ACTION_PAUSE |
								PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS |
								PlaybackStateCompat.ACTION_PLAY_PAUSE);

		mMediaSession.setPlaybackState(mStateBuilder.build());

		// MySessionCallback has methods that handle callbacks from a media controller.
		mMediaSession.setCallback(new MySessionCallback());

		// Start the Media Session since the activity is active.
		mMediaSession.setActive(true);

	}

	/**
	 * Media Session Callbacks, where all external clients control the player.
	 */
	private class MySessionCallback extends MediaSessionCompat.Callback {

		@Override
		public void onPause() {
			mExoPlayer.setPlayWhenReady(false);
		}

		@Override
		public void onPlay() {
			mExoPlayer.setPlayWhenReady(true);
		}

		@Override
		public void onSkipToPrevious() {
			mExoPlayer.seekTo(0);
		}
	}

	@Override
	public void onSaveInstanceState(@NotNull Bundle outState) {
		outState.putInt(STATE_RESUME_WINDOW, mResumeWindow);
		outState.putLong(STATE_RESUME_POSITION, mResumePosition);
		outState.putBoolean(STATE_PLAYER_FULLSCREEN, mExoPlayerFullscreen);
		if (null != mExoPlayer) {
			isPlayWhenReady = mExoPlayer.getPlayWhenReady();
		}
		outState.putBoolean(PLAY_STATE, isPlayWhenReady);
		super.onSaveInstanceState(outState);
	}

	private void initFullscreenDialog() {
		mFullScreenDialog = new Dialog(Objects.requireNonNull(getActivity()), android.R.style.Theme_Black_NoTitleBar) {
			public void onBackPressed() {
				if (mExoPlayerFullscreen)
					closeFullscreenDialog();
				super.onBackPressed();
			}
		};
	}

	private void closeFullscreenDialog() {
		assert binding.exoplayer != null;
		((ViewGroup) mExoPlayerView.getParent()).removeView(mExoPlayerView);
		assert mainMediaFrame != null;
		mainMediaFrame.addView(mExoPlayerView);
		mExoPlayerFullscreen = false;
		mFullScreenDialog.dismiss();
		//assert mFullScreenIcon != null;
		//mFullScreenIcon.setImageDrawable(fullscreenExpand);
	}

	/**
	 * Release ExoPlayer.
	 */
	private void releasePlayer() {
		if (mNotificationManager != null) {
			mNotificationManager.cancelAll();
		}
		if (mExoPlayer != null) {
			mExoPlayer.stop();
			mExoPlayer.release();
			mExoPlayer = null;
			mMediaSession.setActive(false);
		}
	}

	/**
	 * Shows Media Style notification, with actions that depend on the current MediaSession
	 * PlaybackState.
	 *
	 * @param state The PlaybackState of the MediaSession.
	 */
	private void showNotification(PlaybackStateCompat state) {

		NotificationCompat.Builder builder = new NotificationCompat.Builder(Objects.requireNonNull(getActivity()), CHANNEL_ID);

		int icon;
		String play_pause;
		if (state.getState() == PlaybackStateCompat.STATE_PLAYING) {
			icon = R.drawable.exo_controls_pause;
			play_pause = getString(R.string.pause);
		} else {
			icon = R.drawable.exo_controls_play;
			play_pause = getString(R.string.play);
		}

		NotificationCompat.Action playPauseAction = new NotificationCompat.Action(
				icon, play_pause,
				MediaButtonReceiver.buildMediaButtonPendingIntent(getActivity(),
						PlaybackStateCompat.ACTION_PLAY_PAUSE));

		NotificationCompat.Action restartAction = new NotificationCompat
				.Action(R.drawable.exo_controls_previous, "restart",
				MediaButtonReceiver.buildMediaButtonPendingIntent
						(getActivity(), PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS));

		PendingIntent contentPendingIntent = PendingIntent.getActivity
				(getActivity(), 0, new Intent(getActivity(), EpisodeDetailActivity.class), 0);

		builder.setContentTitle(searchedItem.getTitleOriginal())
				.setContentText(getString(R.string.notification_text))
				.setContentIntent(contentPendingIntent)
				.setSmallIcon(R.drawable.ic_music_note)
				.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
				.addAction(restartAction)
				.addAction(playPauseAction);

		mNotificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
					"ANVCE_BAKING_APP",
					NotificationManager.IMPORTANCE_DEFAULT);
			channel.setDescription("Recipe step details");
			mNotificationManager.createNotificationChannel(channel);
		}

		mNotificationManager.notify(0, builder.build());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (TextUtils.isEmpty(searchedItem.getAudio())) {
			return;
		}
		if (mExoPlayerFullscreen) {
			mExoPlayerFullscreen = false;
			if (mFullScreenDialog != null) {
				mFullScreenDialog.dismiss();
			}
		}
		releasePlayer();
	}

	@Override
	public void onPause() {
		super.onPause();
		if (TextUtils.isEmpty(searchedItem.getAudio())) {
			return;
		}
		if (mExoPlayerView != null && mExoPlayerView.getPlayer() != null) {
			mResumeWindow = mExoPlayerView.getPlayer().getCurrentWindowIndex();
			mResumePosition = Math.max(0, mExoPlayerView.getPlayer().getCurrentPosition());
			mExoPlayerView.getPlayer().release();
		}

		if (mFullScreenDialog != null)
			mFullScreenDialog.dismiss();
	}

	/**
	 * Method that is called when the ExoPlayer state changes. Used to update the MediaSession
	 * PlayBackState to keep in sync, and post the media notification.
	 *
	 * @param playWhenReady true if ExoPlayer is playing, false if it's paused.
	 * @param playbackState int describing the state of ExoPlayer. Can be STATE_READY, STATE_IDLE,
	 *                      STATE_BUFFERING, or STATE_ENDED.
	 */
	@Override
	public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
		if ((playbackState == ExoPlayer.STATE_READY) && playWhenReady) {
			mStateBuilder.setState(PlaybackStateCompat.STATE_PLAYING,
					mExoPlayer.getCurrentPosition(), 1f);
		} else if ((playbackState == ExoPlayer.STATE_READY)) {
			mStateBuilder.setState(PlaybackStateCompat.STATE_PAUSED,
					mExoPlayer.getCurrentPosition(), 1f);
		}
		mMediaSession.setPlaybackState(mStateBuilder.build());
		showNotification(mStateBuilder.build());
	}

	@Override
	public void onPlayerError(ExoPlaybackException error) {
		Log.e(TAG, "error during playback - ", error);
		assert mExoPlayerView != null;
		mExoPlayerView.setVisibility(View.GONE);
	}

	@Override
	public void onPositionDiscontinuity(int reason) {

	}

	@Override
	public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

	}

	@Override
	public void onSeekProcessed() {

	}

	@Override
	public void onRepeatModeChanged(int repeatMode) {

	}

	@Override
	public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

	}

	/**
	 * Broadcast Receiver registered to receive the MEDIA_BUTTON intent coming from clients.
	 */
	public static class MediaReceiver extends BroadcastReceiver {

		public MediaReceiver() {
		}

		@Override
		public void onReceive(Context context, Intent intent) {
			MediaButtonReceiver.handleIntent(mMediaSession, intent);
		}
	}

}
