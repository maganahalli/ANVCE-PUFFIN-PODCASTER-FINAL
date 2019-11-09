package com.mobile.anvce.puffinpodcaster.ui;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobile.anvce.puffinpodcaster.BaseNavigationActivity;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

public class SearchedKeyWordEpisodesListActivity extends BaseNavigationActivity implements PodcastConstatnts {

	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_searched_keyword_episodes;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupNavigationView();
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

}
