package com.mobile.anvce.puffinpodcaster.database;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Models Curated Podcast for Room Database
 * @author Venkatesh Maganahalli
 */
@Entity(tableName = "CURATED_PODCAST_TABLE")
public class DbCuratedPodcast {

	private String curatedListId;
	private String curatedPodcastId;
	@NonNull
	@PrimaryKey(autoGenerate = true)
	private int id;
	private String image;
	private String listennotes_url;
	private String publisher;
	private String source_domain;
	private String thumbnail;
	private String title;

	public DbCuratedPodcast(int id, String curatedPodcastId, String curatedListId, String title, String image, String publisher, String thumbnail, String source_domain, String listennotes_url) {
		super();
		this.id = id;
		this.curatedPodcastId = curatedPodcastId;
		this.curatedListId = curatedListId;
		this.title = title;
		this.image = image;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.source_domain = source_domain;
		this.listennotes_url = listennotes_url;
	}

	@Ignore
	public DbCuratedPodcast() {
	}

	public String getCuratedListId() {
		return curatedListId;
	}

	public String getCuratedPodcastId() {
		return curatedPodcastId;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getListennotes_url() {
		return listennotes_url;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getSource_domain() {
		return source_domain;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setCuratedListId(String curatedListId) {
		this.curatedListId = curatedListId;
	}

	public void setCuratedPodcastId(String curatedPodcastId) {
		this.curatedPodcastId = curatedPodcastId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setListennotes_url(String listennotes_url) {
		this.listennotes_url = listennotes_url;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setSource_domain(String source_domain) {
		this.source_domain = source_domain;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
