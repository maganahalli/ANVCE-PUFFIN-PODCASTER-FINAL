package com.mobile.anvce.puffinpodcaster.ui.search;

import java.util.Objects;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobile.anvce.puffinpodcaster.BaseNavigationActivity;
import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class SearchableActivity extends BaseNavigationActivity implements PodcastConstatnts {

	private PodcastSearchItem searchItem;

	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_searchable;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		considerExtractingSearchItem();
		String title = searchItem.getKeyword();
		setTitle(title);
		getSupportActionBar().setTitle(title);
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

	private void considerExtractingSearchItem() {
		// The detail Activity called via intent.  Inspect the intent for MovieDetails data.
		Intent intent = Objects.requireNonNull(getIntent());
		if (intent != null && intent.hasExtra(SEARCH_ITEM_KEY)) {
			searchItem = intent.getParcelableExtra(SEARCH_ITEM_KEY);
		}
	}
}
