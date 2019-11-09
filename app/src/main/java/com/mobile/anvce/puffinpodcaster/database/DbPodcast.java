package com.mobile.anvce.puffinpodcaster.database;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Models Podcast for Room Database
 * @author Venkatesh Maganahalli
 */
@Entity(tableName = "PODCAST_TABLE")
public class DbPodcast  {

	private String country;
	private String description;
	private Long earliestPubDateMs;
	private String email;
	private Boolean explicitContent;
	private String genreIdsAsString;
	@NonNull
	@PrimaryKey(autoGenerate = true)
	private int id;
	private String image;
	private Boolean isClaimed;
	private int itunesId;
	private String language;
	private Long latestPubDateMs;
	private String listennotesUrl;
	private String podcastExtraAsString;
	private String podcastId;
	private String podcastLookingForAsString;
	private String publisher;
	private String rss;
	private String thumbnail;
	private String title;
	private int totalEpisodes;
	private String website;

	public DbPodcast(int id, String podcastId, String rss, String email, String podcastExtraAsString, String image, String title, String country, String website, String language, String genreIdsAsString, int itunesId, String publisher, String thumbnail, Boolean isClaimed, String description, String podcastLookingForAsString, int totalEpisodes, String listennotesUrl, Boolean explicitContent, Long latestPubDateMs, Long earliestPubDateMs) {
		super();
		this.id = id;
		this.podcastId = podcastId;
		this.rss = rss;
		this.email = email;
		this.podcastExtraAsString = podcastExtraAsString;
		this.image = image;
		this.title = title;
		this.country = country;
		this.website = website;
		this.language = language;
		this.genreIdsAsString = genreIdsAsString;
		this.itunesId = itunesId;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.isClaimed = isClaimed;
		this.description = description;
		this.podcastLookingForAsString = podcastLookingForAsString;
		this.totalEpisodes = totalEpisodes;
		this.listennotesUrl = listennotesUrl;
		this.explicitContent = explicitContent;
		this.latestPubDateMs = latestPubDateMs;
		this.earliestPubDateMs = earliestPubDateMs;
	}

	@Ignore
	public DbPodcast() {
	}

	public Boolean getClaimed() {
		return isClaimed;
	}

	public String getCountry() {
		return country;
	}

	public String getDescription() {
		return description;
	}

	public Long getEarliestPubDateMs() {
		return earliestPubDateMs;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getExplicitContent() {
		return explicitContent;
	}

	public String getGenreIdsAsString() {
		return genreIdsAsString;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public int getItunesId() {
		return itunesId;
	}

	public String getLanguage() {
		return language;
	}

	public Long getLatestPubDateMs() {
		return latestPubDateMs;
	}

	public String getListennotesUrl() {
		return listennotesUrl;
	}

	public String getPodcastExtraAsString() {
		return podcastExtraAsString;
	}

	public String getPodcastId() {
		return podcastId;
	}

	public String getPodcastLookingForAsString() {
		return podcastLookingForAsString;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getRss() {
		return rss;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public int getTotalEpisodes() {
		return totalEpisodes;
	}

	public String getWebsite() {
		return website;
	}

	public void setClaimed(Boolean claimed) {
		isClaimed = claimed;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEarliestPubDateMs(Long earliestPubDateMs) {
		this.earliestPubDateMs = earliestPubDateMs;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExplicitContent(Boolean explicitContent) {
		this.explicitContent = explicitContent;
	}

	public void setGenreIdsAsString(String genreIdsAsString) {
		this.genreIdsAsString = genreIdsAsString;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setItunesId(int itunesId) {
		this.itunesId = itunesId;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLatestPubDateMs(Long latestPubDateMs) {
		this.latestPubDateMs = latestPubDateMs;
	}

	public void setListennotesUrl(String listennotesUrl) {
		this.listennotesUrl = listennotesUrl;
	}

	public void setPodcastExtraAsString(String podcastExtraAsString) {
		this.podcastExtraAsString = podcastExtraAsString;
	}

	public void setPodcastId(String podcastId) {
		this.podcastId = podcastId;
	}

	public void setPodcastLookingForAsString(String podcastLookingForAsString) {
		this.podcastLookingForAsString = podcastLookingForAsString;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setRss(String rss) {
		this.rss = rss;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTotalEpisodes(int totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}