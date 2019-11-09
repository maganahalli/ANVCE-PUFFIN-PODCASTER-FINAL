package com.mobile.anvce.puffinpodcaster.api;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.api.model.EpisodeListResponse;
import com.mobile.anvce.puffinpodcaster.api.model.PodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit Service Contract and route declaration.
 */

public interface PuffinPodcastService {

    @GET("/api/v2/best_podcasts")
    Call<PodcastServiceResponse> getBestPodcastList(@Query(value = "genre_id", encoded = false) String genreId, @Query(value = "page", encoded = false) String page, @Query(value = "region", encoded = false) String region, @Query(value = "safe_mode", encoded = false) String safe_mode);

    @GET("/api/v2/curated_podcasts")
    Call<CuratedPodcastServiceResponse> getCuratedPodcastList(@Query(value = "page", encoded = false) String page);

    @GET("/api/v2/search")
    Call<SearchResult> getSearchResults(@Query(value = "q", encoded = false) String searchKey, @Query(value = "sort_by_date", encoded = false) int sortOrder, @Query(value = "type", encoded = false) String type, @Query(value = "offset", encoded = false) int offset, @Query(value = "len_min", encoded = false) int minLen,
                                        @Query(value = "len_max", encoded = false) int maxLen, @Query(value = "genre_ids", encoded = false) String genIds, @Query(value = "published_before", encoded = false) int pulishedBefore,
                                        @Query(value = "published_after", encoded = false) int pulishedAfter, @Query(value = "only_in", encoded = false) String onlyIn, @Query(value = "language", encoded = false) String language,
                                        @Query(value = "safe_mode", encoded = false) int safeNode);
    @GET("/api/v2/podcasts/{podcastId}")
    Call<EpisodeListResponse> getEpisodeList(@Path("podcastId") String podcastId, @Query(value = "sort", encoded = false) String sortOrder);


}
