package com.mobile.anvce.puffinpodcaster.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DbPodcast.class, DbCuratedList.class, DbCuratedPodcast.class, DbEpisode.class, DbListeningHistory.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

	private static final String DATABASE_NAME = "puffinPodcasts";
	private static final Object LOCK = new Object();
	private static final String TAG = AppDatabase.class.getSimpleName();
	private static AppDatabase singleInstance;

	public static AppDatabase getInstance(Context context) {
		if (singleInstance == null) {
			synchronized (LOCK) {
				Log.d(TAG, "Creating Database Instance");
				singleInstance = Room.databaseBuilder(context.getApplicationContext(),
						AppDatabase.class, AppDatabase.DATABASE_NAME).build();
			}

		}
		Log.d(TAG, "Getting Database Instance");
		return singleInstance;
	}

	public abstract PuffinPodcastsDao podcastsDao();
}
