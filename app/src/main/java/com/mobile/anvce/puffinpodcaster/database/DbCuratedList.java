package com.mobile.anvce.puffinpodcaster.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Models Curated List for Room Database
 * @author Venkatesh Maganahalli
 */
@Entity(tableName = "CURATED_LIST_TABLE")
public class DbCuratedList  {

	private String curatedListId;
	private String description;
	@PrimaryKey(autoGenerate = true)
	private int id;
	private String listennotes_url;
	private String cuaratedPodcastsListAsString;
	private String pub_date_ms;
	private String source_domain;
	private String source_url;
	private String title;

	public DbCuratedList(int id, String curatedListId, String title, String cuaratedPodcastsListAsString, String source_url, String description, String pub_date_ms, String source_domain, String listennotes_url) {
		super();
		this.id = id;
		this.curatedListId = curatedListId;
		this.title = title;
		this.cuaratedPodcastsListAsString = cuaratedPodcastsListAsString;
		this.source_url = source_url;
		this.description = description;
		this.pub_date_ms = pub_date_ms;
		this.source_domain = source_domain;
		this.listennotes_url = listennotes_url;
	}

	@Ignore
	public DbCuratedList() {

	}

	public String getCuratedListId() {
		return curatedListId;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getListennotes_url() {
		return listennotes_url;
	}

	public String getCuaratedPodcastsListAsString() {
		return cuaratedPodcastsListAsString;
	}

	public String getPub_date_ms() {
		return pub_date_ms;
	}

	public String getSource_domain() {
		return source_domain;
	}

	public String getSource_url() {
		return source_url;
	}

	public String getTitle() {
		return title;
	}

	public void setCuratedListId(String curatedListId) {
		this.curatedListId = curatedListId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListennotes_url(String listennotes_url) {
		this.listennotes_url = listennotes_url;
	}

	public void setCuaratedPodcastsListAsString(String cuaratedPodcastsListAsString) {
		this.cuaratedPodcastsListAsString = cuaratedPodcastsListAsString;
	}

	public void setPub_date_ms(String pub_date_ms) {
		this.pub_date_ms = pub_date_ms;
	}

	public void setSource_domain(String source_domain) {
		this.source_domain = source_domain;
	}

	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
