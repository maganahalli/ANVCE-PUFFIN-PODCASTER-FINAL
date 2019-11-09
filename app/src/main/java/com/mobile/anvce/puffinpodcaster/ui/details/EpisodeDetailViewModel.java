package com.mobile.anvce.puffinpodcaster.ui.details;

import android.app.Application;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.repository.EpisodeDetailsRepository;
import com.mobile.anvce.puffinpodcaster.repository.ListeningPodcastsHistoryRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class EpisodeDetailViewModel extends AndroidViewModel {

	private final EpisodeDetailsRepository detailsRepository;
	private final ListeningPodcastsHistoryRepository historyRepository;

	public EpisodeDetailViewModel(@NonNull Application application) {
		super(application);
		detailsRepository = new EpisodeDetailsRepository(application);
		historyRepository = new ListeningPodcastsHistoryRepository(application);
	}

	public void saveEpisodeToFavoriteList(Episode episodeItem) {
		detailsRepository.saveEpisodeToFavoriteList(episodeItem);
	}

	public void saveEpisodeToPlayLaterList(Episode episodeItem) {
		detailsRepository.saveEpisodeToPlayLaterList(episodeItem);
	}

	public void saveEpisodeToListeningHitory(Episode episodeItem) {
		historyRepository.saveEpisodeToListeningHistoryDatabase(episodeItem);
	}

}
