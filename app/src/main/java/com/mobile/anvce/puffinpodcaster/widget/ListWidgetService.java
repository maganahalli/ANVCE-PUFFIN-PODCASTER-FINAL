package com.mobile.anvce.puffinpodcaster.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;

import static com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants.PREF_POPULAR_PODCAST_KEY;

public class ListWidgetService extends RemoteViewsService {

	@Override
	public RemoteViewsFactory onGetViewFactory(Intent intent) {
		// Creates and returns a ListRemoteViewsFactory
		return new ListRemoteViewsFactory(this.getApplicationContext());
	}

	class ListRemoteViewsFactory implements RemoteViewsFactory {

		private Context mContext;
		private List<Podcast> podcasts;

		public ListRemoteViewsFactory(Context applicationContext) {
			mContext = applicationContext;
		}

		@Override
		public void onCreate() {

		}

		// called on start and when notifyAppWidgetViewDataChanged is called
		@Override
		public void onDataSetChanged() {
			// Get the updated popular podcast string from shared preferences
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

			podcasts = new ArrayList<>();
			String popularPodcastAsString = sharedPreferences.getString(PREF_POPULAR_PODCAST_KEY, "");
			if (!TextUtils.isEmpty(popularPodcastAsString)) {
				List<Podcast> localList = new PodcastCustomDataConverter().toPodcastListFromSharePref(popularPodcastAsString);
				podcasts.clear();
				podcasts.addAll(localList);
			}

		}

		@Override
		public void onDestroy() {

		}

		/**
		 * Returns the number of items to be displayed in the ListView widget
		 */
		@Override
		public int getCount() {
			if (podcasts == null) return 0;
			return podcasts.size();
		}

		/**
		 * This method acts like the onBindViewHolder method in an Adapter.
		 *
		 * @param position The current position of the item in the GridView to be displayed
		 * @return The RemoteViews object to display for the provided position
		 */
		@Override
		public RemoteViews getViewAt(int position) {
			if (podcasts == null || podcasts.size() == 0) return null;

			Podcast podcast = podcasts.get(position);
			// Extract the ingredient details
			String title = podcast.getTitle();
			String language = podcast.getLanguage();

			RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.podcast_widget);

			views.setTextViewText(R.id.widget_title, title);
			views.setTextViewText(R.id.widget_lang, language);
			return views;
		}

		@Override
		public RemoteViews getLoadingView() {
			return null;
		}

		@Override
		public int getViewTypeCount() {
			return 1; // Treat all items in the ListView the same
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}
	}

}

