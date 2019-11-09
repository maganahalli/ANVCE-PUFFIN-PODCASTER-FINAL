package com.mobile.anvce.puffinpodcaster.database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public abstract interface PuffinPodcastsDao {

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insertPodcast(DbPodcast podcast);

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insertListeningHistory(DbListeningHistory history);

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insertCuratedPodcast(DbCuratedPodcast curatedPodcast);

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insertCuratedList(DbCuratedList curatedList);

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insertEpisode(DbEpisode episode);

	@Query("SELECT * FROM CURATED_LIST_TABLE WHERE curatedListId =:id")
	DbCuratedList retrieveCuratedListById(String id);

	@Query("SELECT * FROM LISTENING_HISTORY_TABLE WHERE episodeId =:id")
	DbListeningHistory retrieveListeningHistoryById(String id);

	@Query("SELECT * FROM EPISODE_TABLE WHERE episodeId =:id")
	DbEpisode retrieveEpisodeById(String id);

	@Update(onConflict = OnConflictStrategy.IGNORE)
	void updatePodcast(DbPodcast podcast);

	@Update(onConflict = OnConflictStrategy.IGNORE)
	void updateEpisode(DbEpisode episode);

	@Update(onConflict = OnConflictStrategy.IGNORE)
	void updateCuratedPodcast(DbCuratedPodcast curatedPodcast);

	@Update(onConflict = OnConflictStrategy.IGNORE)
	void updateListeningHistory(DbListeningHistory history);

	@Update(onConflict = OnConflictStrategy.IGNORE)
	void updateCuratedList(DbCuratedList curatedList);

	@Delete
	void deleteEpisode(DbEpisode dbEpisode);

	@Query("SELECT * FROM LISTENING_HISTORY_TABLE")
	List<DbListeningHistory> fetchListeningHistory();

	@Query("SELECT * FROM PODCAST_TABLE")
	List<DbPodcast> fetchAllPodcasts();

	@Query("SELECT * FROM CURATED_LIST_TABLE")
	List<DbCuratedList> fetchAllCuratedList();

	@Query("SELECT * FROM CURATED_PODCAST_TABLE")
	List<DbCuratedPodcast> fetchAllCuratedPodcast();

	@Query("SELECT * FROM PODCAST_TABLE")
	LiveData<List<DbPodcast>> loadAllPodcasts();

	@Query("SELECT * FROM PODCAST_TABLE WHERE podcastId =:podcastId")
	DbPodcast retrievePodcastById(String podcastId);

	@Query("SELECT * FROM EPISODE_TABLE WHERE category =:category")
	List<DbEpisode> fetchAllPlayLaterEpisodes(String category);

	@Query("SELECT * FROM EPISODE_TABLE WHERE category =:category")
	LiveData<List<DbEpisode>> loadAllPlayLaterEpisodes(String category);

}
