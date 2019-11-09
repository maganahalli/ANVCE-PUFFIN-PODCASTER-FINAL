package com.mobile.anvce.puffinpodcaster.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.RemoteViews;

import com.mobile.anvce.puffinpodcaster.PuffinPodcasterMainActivity;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.ui.EpisodesListActivity;

public class PuffinPodcasterWidgetProvider extends AppWidgetProvider implements PuffinPodcasterConstants {

	static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
			int appWidgetId) {

		RemoteViews views = getPopularPodcastsRemoteView(context, appWidgetId);

		// Instruct the widget manager to update the widget
		appWidgetManager.updateAppWidget(appWidgetId, views);
	}

	/**
	 * Update the recipe name in the app widget.
	 */
	static void updateAppWidgetTitle(Context context, AppWidgetManager appWidgetManager,
			int appWidgetId) {
		RemoteViews views = getTitleRemoteView(context);

		// Instruct the widget manager to update the widget
		appWidgetManager.updateAppWidget(appWidgetId, views);
	}

	/**
	 * Creates and returns the RemoteViews to be displayed in the TextView widget
	 *
	 * @param context The context of the app
	 * @return The RemoteViews for displaying recipe name
	 */
	private static RemoteViews getTitleRemoteView(Context context) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		// Get the updated popular podcast string from shared preferences
		List<Podcast> podcasts = new ArrayList<>();
		String popularPodcastAsString = sharedPreferences.getString(PREF_POPULAR_PODCAST_KEY, "");
		if (!TextUtils.isEmpty(popularPodcastAsString)) {
			List<Podcast> localList = new PodcastCustomDataConverter().toPodcastListFromSharePref(popularPodcastAsString);
			podcasts.clear();
			podcasts.addAll(localList);
		}

		// Extract recipe data used for creating the recipe object
		// Create an Intent to launch MainActivity or DetailActivity when clicked
		Intent intent;

		// Construct the RemoteViews object
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_list_view);

		// In this case, launch the MainActivity. Otherwise, launch the EpisodeListActivity.
		if (popularPodcastAsString.isEmpty()) {
			intent = new Intent(context, PuffinPodcasterMainActivity.class);
			// Display the app name in the app widget
			views.setTextViewText(R.id.widget_podcast_name, context.getString(R.string.app_name));
		} else {
			intent = new Intent(context, EpisodesListActivity.class);

			// Pass the bundle through Intent
			Bundle bundle = new Bundle();
			bundle.putParcelable(PODCAST_ITEM_KEY, podcasts.get(0));
			intent.putExtra(PODCAST_TYPE_KEY, bundle);
		}
		// Display the app name in the app widget
		views.setTextViewText(R.id.widget_podcast_name, context.getString(R.string.app_name));
		// Widgets allow click handlers to only launch pending intents
		PendingIntent pendingIntent = PendingIntent.getActivity(context, WIDGET_PENDING_INTENT_ID,
				intent, PendingIntent.FLAG_UPDATE_CURRENT);
		views.setOnClickPendingIntent(R.id.widget_empty_view, pendingIntent);

		return views;
	}

	/**
	 * Creates and returns the RemoteViews to be displayed in the ListView mode widget
	 *
	 * @param context The context
	 * @return The RemoteViews for the ListView mode widget
	 */
	private static RemoteViews getPopularPodcastsRemoteView(Context context, int appWidgetId) {
		// Construct the RemoteViews object
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_list_view);

		// Set up the intent that starts the ListWidgetService, which will provide the views for
		// this collection
		Intent intent = new Intent(context, ListWidgetService.class);
		// Add the app widget Id to the intent extras
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
		views.setRemoteAdapter(R.id.widget_list_view, intent);

		// Handle empty view
		views.setEmptyView(R.id.widget_list_view, R.id.widget_empty_view);
		return views;
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		// There may be multiple widgets active, so update all of them
		for (int appWidgetId : appWidgetIds) {
			updateAppWidget(context, appWidgetManager, appWidgetId);
			// Update the recipe name in the app widget
			updateAppWidgetTitle(context, appWidgetManager, appWidgetId);
		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

		String action = intent.getAction();
		if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) {
			int[] appWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
			for (int appWidgetId : appWidgetIds) {
				updateAppWidget(context, appWidgetManager, appWidgetId);
			}
			// Trigger data update to handle the ListView widgets and force a data refresh
			appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_list_view);
		}
		super.onReceive(context, intent);
	}

	@Override
	public void onEnabled(Context context) {
		// Enter relevant functionality for when the first widget is created
	}

	@Override
	public void onDisabled(Context context) {
		// Enter relevant functionality for when the last widget is disabled
	}
}

