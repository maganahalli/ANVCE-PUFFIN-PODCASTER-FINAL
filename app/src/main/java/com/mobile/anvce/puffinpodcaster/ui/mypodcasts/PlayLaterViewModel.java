package com.mobile.anvce.puffinpodcaster.ui.mypodcasts;

import java.util.List;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.repository.PlayLaterEpisodeRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PlayLaterViewModel extends AndroidViewModel {

	private final PlayLaterEpisodeRepository playLaterEpisodeRepository;

	public PlayLaterViewModel(@NonNull Application application) {
		super(application);
		playLaterEpisodeRepository = new PlayLaterEpisodeRepository(application);
	}

	public LiveData<List<DbEpisode>> getPlayLaterEpisodesList() {
		return playLaterEpisodeRepository.getDbEpisodeList();
	}

}
