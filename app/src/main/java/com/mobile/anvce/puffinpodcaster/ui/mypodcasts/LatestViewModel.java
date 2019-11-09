package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.repository.PlayFavoriteEpisodeRepository;

import java.util.List;

public class LatestViewModel extends AndroidViewModel {
    private final PlayFavoriteEpisodeRepository favoriteEpisodeRepository;
    public LatestViewModel(@NonNull Application application) {
        super(application);
        favoriteEpisodeRepository = new PlayFavoriteEpisodeRepository(application);
    }

    public LiveData<List<DbEpisode>> getFavoriteEpisodesList() {
        return favoriteEpisodeRepository.getDbEpisodeList();
    }
}
