package com.mobile.anvce.puffinpodcaster.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import com.mobile.anvce.puffinpodcaster.PuffinPodcasterMainActivity;
import com.mobile.anvce.puffinpodcaster.R;

import androidx.core.app.NotificationCompat;

public class NotificationUtils {

	private static final int PODCAST_NOTIFICATION_ID = 3005;

	/**
	 * Constructs and displays a notification for the newly updated podcasts for today.
	 *
	 * @param context Context used to query for Popular Podcasts
	 */
	public static void notifyUserOfNewPodcast(Context context) {
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		String channelId = context.getString(R.string.notificationChannelId);
		String title = context.getString(R.string.notificationTitle);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel notificationChannel = new NotificationChannel(channelId, title, NotificationManager.IMPORTANCE_HIGH);

			// Configure the notification channel.
			notificationChannel.setDescription(title);
			notificationChannel.enableLights(true);
			notificationChannel.setLightColor(Color.RED);
			notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
			notificationChannel.enableVibration(true);
			notificationManager.createNotificationChannel(notificationChannel);
		}

		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, channelId);
		PendingIntent contentPendingIntent = PendingIntent.getActivity
				(context, 0, new Intent(context, PuffinPodcasterMainActivity.class), 0);
		notificationBuilder.setAutoCancel(true)
				.setDefaults(Notification.DEFAULT_ALL)
				.setWhen(System.currentTimeMillis())
				.setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
				.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
				.setContentIntent(contentPendingIntent)
				.setContentTitle(title);

		notificationManager.notify(PODCAST_NOTIFICATION_ID, notificationBuilder.build());
	}

}


