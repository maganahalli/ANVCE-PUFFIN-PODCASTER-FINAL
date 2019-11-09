package com.mobile.anvce.puffinpodcaster.sync;

import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.Intent;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;
import com.mobile.anvce.puffinpodcaster.enums.PodcastUpdateFrequency;
import com.mobile.anvce.puffinpodcaster.enums.PodcastUpdateFrequency.PodcastUpdateFrequencyVisitor;

import androidx.annotation.NonNull;

public class PodcastsSyncUtils {

	private static boolean sInitialized;

	//Add a sync tag to identify our sync job
	private static final String PODCASTS_SYNC_TAG = "podcasts-sync";

	/**
	 * Schedules a repeating sync of podcasts data using FirebaseJobDispatcher.
	 * @param context Context used to create the GooglePlayDriver that powers the
	 *                FirebaseJobDispatcher
	 */

	public static void scheduleFirebaseJobDispatcherSync(@NonNull final Context context, @NonNull PodcastUpdateFrequency frequency) {

		/*
		 * Interval at which to sync with the podcasts. Use TimeUnit for convenience, rather than
		 * writing out a bunch of multiplication ourselves and risk making a silly mistake.
		 */
		int syncIntervalHours = frequency.acceptVisitor(new UpdateFrequencyHandler());
		int syncIntervalSeconds = (int) TimeUnit.HOURS.toSeconds(syncIntervalHours);
		int syncFlextimeSeconds = syncIntervalSeconds / 3;

		Driver driver = new GooglePlayDriver(context);
		FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

		/* Create the Job to periodically sync Sunshine */
		Job syncSunshineJob = dispatcher.newJobBuilder()
				/* The Service that will be used to sync Sunshine's data */
				.setService(PodcastsFirebaseJobService.class)
				/* Set the UNIQUE tag used to identify this Job */
				.setTag(PODCASTS_SYNC_TAG)
				/*
				 * Network constraints on which this Job should run. We choose to run on any
				 * network, but you can also choose to run only on un-metered networks or when the
				 * device is charging. It might be a good idea to include a preference for this,
				 * as some users may not want to download any data on their mobile plan. ($$$)
				 */
				.setConstraints(Constraint.ON_UNMETERED_NETWORK)
				/*
				 * setLifetime sets how long this job should persist. The options are to keep the
				 * Job "forever" or to have it die the next time the device boots up.
				 */
				.setLifetime(Lifetime.FOREVER)
				/*
				 * We want Sunshine's weather data to stay up to date, so we tell this Job to recur.
				 */
				.setRecurring(true)
				/*
				 * We want the podcast data to be synced every 24 hours. The first argument for
				 * Trigger's static executionWindow method is the start of the time frame when the
				 * sync should be performed. The second argument is the latest point in time at
				 * which the data should be synced. Please note that this end time is not
				 * guaranteed, but is more of a guideline for FirebaseJobDispatcher to go off of.
				 */
				.setTrigger(Trigger.executionWindow(
						syncIntervalHours,
						syncIntervalSeconds + syncFlextimeSeconds))
				/*
				 * If a Job with the tag with provided already exists, this new job will replace
				 * the old one.
				 */
				.setReplaceCurrent(true)
				/* Once the Job is ready, call the builder's build method to return the Job */
				.build();

		/* Schedule the Job with the dispatcher */
		dispatcher.schedule(syncSunshineJob);
	}

	private static class UpdateFrequencyHandler implements PodcastUpdateFrequencyVisitor<Void, Integer> {

		@Override
		public Integer visitEightHour(Void input) {
			return 8;
		}

		@Override
		public Integer visitEveryDay(Void input) {
			return 24;
		}

		@Override
		public Integer visitWeekly(Void input) {
			return 168;
		}
	}

	/**
	 * Helper method to perform a sync immediately using an IntentService for asynchronous
	 * execution.
	 *
	 * @param context The Context used to start the IntentService for the sync.
	 */
	public static void startImmediateSync(@NonNull final Context context) {
		Intent intentToSyncImmediately = new Intent(context, PodcastsSyncIntentService.class);
		context.startService(intentToSyncImmediately);
	}

	/**
	 * Creates periodic sync tasks and checks to see if an immediate sync is required. If an
	 * immediate sync is required, this method will take care of making sure that sync occurs.
	 *
	 * @param context Context that will be passed to other methods and used to access the
	 *                ContentResolver
	 */
	synchronized public static void initialize(@NonNull final Context context, @NonNull final PodcastUpdateFrequency frequency) {

		/*
		 * Only perform initialization once per app lifetime. If initialization has already been
		 * performed, we have nothing to do in this method.
		 */
		if (sInitialized) return;

		sInitialized = true;

		/*
		 * This method call triggers puffin podcaster to create its task to synchronize podcasts data
		 * periodically.
		 */
		scheduleFirebaseJobDispatcherSync(context, frequency);
	}

}
