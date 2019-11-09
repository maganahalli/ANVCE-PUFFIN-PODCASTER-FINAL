package com.mobile.anvce.puffinpodcaster.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcastServiceResponse;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.api.model.PodcastServiceResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils implements ServiceResponseConstatnts, PodcastConstatnts {

	public static PodcastServiceResponse parsePopularPodcastServiceResponse(String jsonString) {

		PodcastServiceResponse serviceResponse = new PodcastServiceResponse();
		try {
			final JSONObject responseObj = new JSONObject(jsonString);
			serviceResponse.setId(Integer.valueOf(responseObj.getString(ID)));
			serviceResponse.setName(responseObj.getString(NAME));
			serviceResponse.setParentId(Integer.valueOf(responseObj.getString(PARENT_ID)));
			serviceResponse.setTotal(Integer.valueOf(responseObj.getString(TOTAL)));
			serviceResponse.setHasNext(Boolean.valueOf(responseObj.getString(HAS_NEXT)));
			serviceResponse.setHasPrevious(Boolean.valueOf(responseObj.getString(HAS_PREVIOUS)));
			serviceResponse.setPageNumber(Integer.valueOf(responseObj.getString(PAGE_NUMBER)));
			serviceResponse.setPreviousPageNumber(Integer.valueOf(responseObj.getString(PREVIOUS_PAGE_NUMBER)));
			serviceResponse.setNextPageNumber(Integer.valueOf(responseObj.getString(NEXT_PAGE_NUMBER)));
			serviceResponse.setListennotesUrl(responseObj.getString(LISTENING_NOTES_URL));
			serviceResponse.setPodcasts(extractPodcastList(responseObj, PODCASTS));

		} catch (JSONException e) {
			e.printStackTrace();
			String message = e.getMessage();
			Logger.getLogger("JsonUtils.class", message);
		}

		return serviceResponse;

	}

	public static CuratedPodcastServiceResponse parseCuratedPodcastServiceResponse(String jsonString) {

		CuratedPodcastServiceResponse serviceResponse = new CuratedPodcastServiceResponse();
		try {
			final JSONObject responseObj = new JSONObject(jsonString);
			serviceResponse.setTotal(Integer.valueOf(responseObj.getString(TOTAL)));
			serviceResponse.setHasNext(Boolean.valueOf(responseObj.getString(HAS_NEXT)));
			serviceResponse.setHasPrevious(Boolean.valueOf(responseObj.getString(HAS_PREVIOUS)));
			serviceResponse.setPageNumber(Integer.valueOf(responseObj.getString(PAGE_NUMBER)));
			serviceResponse.setPreviousPageNumber(Integer.valueOf(responseObj.getString(PREVIOUS_PAGE_NUMBER)));
			serviceResponse.setNextPageNumber(Integer.valueOf(responseObj.getString(NEXT_PAGE_NUMBER)));
			serviceResponse.setCuratedLists(extractCuratedLists(responseObj, CURATED_LISTS));

		} catch (JSONException e) {
			e.printStackTrace();
			String message = e.getMessage();
			Logger.getLogger("JsonUtils.class", message);
		}

		return serviceResponse;

	}

	private static List<CuratedList> extractCuratedLists(JSONObject responseObj, String key) throws JSONException {
		List<CuratedList> curatedLists = new ArrayList<>();
		final JSONArray keyDetailArray = responseObj.getJSONArray(key);
		final int index = keyDetailArray.length();
		for (int i = 0; i < index; ++i) {
			final JSONObject cuartedListObject = (JSONObject) keyDetailArray.get(i);
			CuratedList curatedList = new CuratedList();
			curatedList.setId(cuartedListObject.get(PODCAST_ID).toString());
			curatedList.setTitle(cuartedListObject.getString(PODCAST_TITLE));
			curatedList.setDescription(cuartedListObject.getString(DESCRIPTION));
			curatedList.setSource_domain(cuartedListObject.getString(SOURCE_DOMAIN));
			curatedList.setSource_url(cuartedListObject.getString(SOURCE_URL));
			curatedList.setPub_date_ms(cuartedListObject.getString(PUBLISHED_DATE_STR));
			curatedList.setListennotes_url(cuartedListObject.getString(PODCAST_LISTENING_NOTES_URL));
			curatedList.setPodcasts(extractCuratedPodcastList(cuartedListObject, PODCASTS));
			curatedLists.add(curatedList);
		}

		return curatedLists;

	}

	private static List<CuratedPodcast> extractCuratedPodcastList(JSONObject responseObj, String key) throws JSONException {
		List<CuratedPodcast> curatedPodcastLists = new ArrayList<>();
		final JSONArray keyDetailArray = responseObj.getJSONArray(key);
		final int index = keyDetailArray.length();
		for (int i = 0; i < index; ++i) {
			final JSONObject cuartedPodcastObject = (JSONObject) keyDetailArray.get(i);
			CuratedPodcast cuartedList = new CuratedPodcast();
			cuartedList.setId(cuartedPodcastObject.get(PODCAST_ID).toString());
			cuartedList.setTitle(cuartedPodcastObject.getString(PODCAST_TITLE));
			cuartedList.setImage(cuartedPodcastObject.getString(IMAGE_URL));
			cuartedList.setSource_domain(cuartedPodcastObject.getString(SOURCE_DOMAIN));
			cuartedList.setThumbnail(cuartedPodcastObject.getString(THUMB_NAIL_URL));
			cuartedList.setPublisher(cuartedPodcastObject.getString(PUBLISHER));
			cuartedList.setListennotes_url(cuartedPodcastObject.getString(PODCAST_LISTENING_NOTES_URL));
			curatedPodcastLists.add(cuartedList);
		}

		return curatedPodcastLists;

	}

	private static List<Podcast> extractPodcastList(JSONObject responseObj, String key) throws JSONException {
		List<Podcast> list = new ArrayList<>();
		final JSONArray keyDetailArray = responseObj.getJSONArray(key);

		final int index = keyDetailArray.length();
		for (int i = 0; i < index; ++i) {
			final JSONObject podcastObject = (JSONObject) keyDetailArray.get(i);
			Podcast podcast = new Podcast();
			podcast.setId(podcastObject.get(PODCAST_ID).toString());
			podcast.setEmail(podcastObject.getString(EMAIL));
			podcast.setThumbnail(podcastObject.getString(THUMBNAIL));
			podcast.setTitle(podcastObject.getString(PODCAST_TITLE));
			list.add(podcast);
		}

		return list;
	}

}
