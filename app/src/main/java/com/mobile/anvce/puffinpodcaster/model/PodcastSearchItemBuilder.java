package com.mobile.anvce.puffinpodcaster.model;

public class PodcastSearchItemBuilder {

	private long id;
	private String keyword;
	private String description;
	private int resourceId;

	public PodcastSearchItemBuilder(long id, String keyword, String description, int resourceId) {
		this.id = id;
		this.keyword = keyword;
		this.description = description;
		this.resourceId = resourceId;
	}

	public PodcastSearchItemBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public PodcastSearchItemBuilder setKeyword(String keyword) {
		this.keyword = keyword;
		return this;
	}

	public PodcastSearchItemBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public PodcastSearchItemBuilder setResourceId(int resourceId) {
		this.resourceId = resourceId;
		return this;
	}

	public PodcastSearchItem build(){
		return new PodcastSearchItem(id,keyword,description,resourceId);
	}

}
