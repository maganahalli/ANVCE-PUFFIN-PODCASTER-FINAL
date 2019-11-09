package com.mobile.anvce.puffinpodcaster.database;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.api.model.PodcastExtra;
import com.mobile.anvce.puffinpodcaster.api.model.PodcastLookingFor;
import com.mobile.anvce.puffinpodcaster.api.model.PodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.util.JsonUtils;

import androidx.room.TypeConverter;

public final class PodcastCustomDataConverter implements Serializable {

	private Gson gson = new Gson();

	public String fromCuratedPodcastList(List<CuratedPodcast> curatedPodcasts) {
		if (curatedPodcasts == null) {
			return (null);
		}
		Type type = new TypeToken<List<CuratedPodcast>>() {
		}.getType();
		return gson.toJson(curatedPodcasts, type);
	}

	@TypeConverter // note this annotation
	public String fromCuratedtList(List<CuratedList> curatedLists) {
		if (curatedLists == null) {
			return (null);
		}
		Type type = new TypeToken<List<CuratedList>>() {
		}.getType();
		return gson.toJson(curatedLists, type);
	}

	@TypeConverter // note this annotation
	public String fromPodcastList(List<Podcast> podcastList) {
		if (podcastList == null) {
			return (null);
		}
		Type type = new TypeToken<List<Podcast>>() {
		}.getType();
		return gson.toJson(podcastList, type);
	}

	@TypeConverter // note this annotation
	public List<CuratedList> toCuratedList(String curatedListAsString) {
		if (curatedListAsString == null) {
			return (null);
		}
		Type type = new TypeToken<CuratedPodcastServiceResponse>() {
		}.getType();

		List<CuratedList> curatedList = new ArrayList();
		try {
			CuratedPodcastServiceResponse response = gson.fromJson(curatedListAsString, type);
			if (!response.getCuratedLists().isEmpty()) {
				curatedList.addAll(response.getCuratedLists());
			}

		} catch (Exception e) {
			CuratedPodcastServiceResponse response = JsonUtils.parseCuratedPodcastServiceResponse(curatedListAsString);
			curatedList = response.getCuratedLists();
		}

		return curatedList;
	}

	@TypeConverter // note this annotation
	public List<CuratedList> toCuratedListFromSharePref(String curatedListAsString) {
		if (curatedListAsString == null) {
			return (null);
		}
		Type type = new TypeToken<List<CuratedList>>() {
		}.getType();

		List<CuratedList> curatedList = new ArrayList();
		try {
			curatedList = gson.fromJson(curatedListAsString, type);
		} catch (Exception e) {
			// do nothing
		}
		return curatedList;
	}

	public List<CuratedPodcast> toCuratedPodcastList(String cuaratedPodcastsListAsString) {
		if(cuaratedPodcastsListAsString == null){
			return null;
		}

		Type type = new TypeToken<List<CuratedPodcast>>() {
		}.getType();

		return gson.fromJson(cuaratedPodcastsListAsString,type);

	}

	@TypeConverter // note this annotation
	public List<Podcast> toPodcastList(String podcastListAsString) {
		if (podcastListAsString == null) {
			return (null);
		}
		Type type = new TypeToken<PodcastServiceResponse>() {
		}.getType();

		List<Podcast> podcastList = new ArrayList();
		try {
			PodcastServiceResponse response = gson.fromJson(podcastListAsString, type);
			if (!response.getPodcasts().isEmpty()) {
				podcastList.addAll(response.getPodcasts());
			}

		} catch (Exception e) {
			PodcastServiceResponse response = JsonUtils.parsePopularPodcastServiceResponse(podcastListAsString);
			podcastList = response.getPodcasts();
		}

		return podcastList;
	}

	@TypeConverter // note this annotation
	public List<Podcast> toPodcastListFromSharePref(String podcastListAsString) {
		if (podcastListAsString == null) {
			return (null);
		}
		Type type = new TypeToken<List<Podcast>>() {
		}.getType();

		List<Podcast> podcastList = new ArrayList();
		try {
			podcastList = gson.fromJson(podcastListAsString, type);
		} catch (Exception e) {
			// do nothing
		}
		return podcastList;
	}

	public String fromGenreIds(List<Integer> genreIds) {
		if (genreIds == null) {
			return (null);
		}
		Type type = new TypeToken<List<Integer>>() {
		}.getType();
		return gson.toJson(genreIds, type);
	}

	public List<Integer> toGenreIds(String genreIdsAsString) {
		if (genreIdsAsString == null) {
			return (null);
		}
		Gson gson = new Gson();
		Type type = new TypeToken<List<Integer>>() {
		}.getType();
		return gson.fromJson(genreIdsAsString, type);
	}

	public String fromPodcastExtra(PodcastExtra podcastExtra) {
		if (podcastExtra == null) {
			return (null);
		}
		Type type = new TypeToken<PodcastExtra>() {
		}.getType();
		return gson.toJson(podcastExtra, type);

	}

	public PodcastExtra toPodcastExtra(String podcastExtraAsString) {
		if (podcastExtraAsString == null) {
			return (null);
		}
		Type type = new TypeToken<PodcastExtra>() {
		}.getType();
		return gson.fromJson(podcastExtraAsString, type);

	}

	public String fromPodcastLookingFor(PodcastLookingFor podcastLookingFor) {
		if (podcastLookingFor == null) {
			return (null);
		}
		Type type = new TypeToken<PodcastLookingFor>() {
		}.getType();
		return gson.toJson(podcastLookingFor, type);

	}

	public PodcastLookingFor toPodcastLookingFor(String podcastLookingForAsString) {
		if (podcastLookingForAsString == null) {
			return (null);
		}
		Type type = new TypeToken<PodcastLookingFor>() {
		}.getType();
		return gson.fromJson(podcastLookingForAsString, type);

	}

	public String fromSearchList(ArrayList<SearchResultByKeyWord> searchPodcastList) {

		if (searchPodcastList == null) {
			return (null);
		}
		Type type = new TypeToken<List<SearchResultByKeyWord>>() {
		}.getType();
		return gson.toJson(searchPodcastList, type);

	}

	public List<SearchResultByKeyWord>  toSearchList(String searchPodcastListAsString) {

		if (searchPodcastListAsString == null) {
			return (null);
		}
		Type type = new TypeToken<List<SearchResultByKeyWord>>() {
		}.getType();
		return gson.fromJson(searchPodcastListAsString, type);

	}
}
