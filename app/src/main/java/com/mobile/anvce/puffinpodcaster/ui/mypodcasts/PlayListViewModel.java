package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import java.util.List;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.repository.PlayFavoriteEpisodeRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PlayListViewModel extends AndroidViewModel {

	private final PlayFavoriteEpisodeRepository favoriteEpisodeRepository;

	public PlayListViewModel(@NonNull Application application) {
		super(application);
		favoriteEpisodeRepository = new PlayFavoriteEpisodeRepository(application);
	}

	public LiveData<List<DbEpisode>> getFavoriteEpisodesList() {
		return favoriteEpisodeRepository.getDbEpisodeList();
	}

}
