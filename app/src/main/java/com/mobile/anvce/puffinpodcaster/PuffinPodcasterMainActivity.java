package com.mobile.anvce.puffinpodcaster;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mobile.anvce.puffinpodcaster.enums.PodcastUpdateFrequency;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.sync.PodcastsSyncUtils;
import com.mobile.anvce.puffinpodcaster.ui.search.SearchableActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.appcompat.widget.SearchView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/**
 * Main Landing Activity to manage Podcasts discovery and listing.
 */
public class PuffinPodcasterMainActivity extends BaseNavigationActivity implements PodcastConstatnts {

	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_main;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupNavigationView();
		PodcastsSyncUtils.initialize(this, PodcastUpdateFrequency.EVERY_DAY);
	}

	private void setupNavigationView() {
		BottomNavigationView navView = findViewById(R.id.bottom_navigation_view);
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
				R.id.navigation_explore, R.id.navigation_mypocasts, R.id.navigation_preferences, R.id.navigation_profile)
				.build();
		NavController navController = Navigation.findNavController(this, R.id.navigation_host_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(navView, navController);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.common_tool_bar_menu, menu);
		// Get the SearchView and set the searchable configuration
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
		// Assumes current activity is the searchable activity
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String query) {
				showMessage(searchView, query);
				PodcastSearchItem searchQuery = new PodcastSearchItem(query, "Search By Keyword", true);
				Intent intent = new Intent(getApplicationContext(), SearchableActivity.class);
				intent.putExtra(SEARCH_ITEM_KEY, searchQuery);
				startActivity(intent);
				return true;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				return false;
			}
		});

		return true;
	}

	private void showMessage(View view, String message) {
		Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
			case R.id.search:
				onSearchRequested();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onSearchRequested() {
		Bundle appData = new Bundle();
		appData.putBoolean("SearchableActivity", true);
		startSearch(null, false, appData, false);
		return super.onSearchRequested();
	}
}
