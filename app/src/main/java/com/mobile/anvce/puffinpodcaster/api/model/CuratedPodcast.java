package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CuratedPodcast implements Parcelable {

	public static final Creator<CuratedPodcast> CREATOR = new Creator<CuratedPodcast>() {
		@Override
		public CuratedPodcast createFromParcel(Parcel in) {
			return new CuratedPodcast(in);
		}

		@Override
		public CuratedPodcast[] newArray(int size) {
			return new CuratedPodcast[size];
		}
	};
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("listennotes_url")
	@Expose
	private String listennotes_url;
	@SerializedName("publisher")
	@Expose
	private String publisher;
	@SerializedName("source_domain")
	@Expose
	private String source_domain;
	@SerializedName("thumbnail")
	@Expose
	private String thumbnail;
	@SerializedName("title")
	@Expose
	private String title;

	public CuratedPodcast() {
	}

	protected CuratedPodcast(Parcel in) {
		id = in.readString();
		title = in.readString();
		image = in.readString();
		publisher = in.readString();
		thumbnail = in.readString();
		source_domain = in.readString();
		listennotes_url = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getId() {
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

	public void setId(String id) {
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

	public CuratedPodcast withId(String id) {
		this.id = id;
		return this;
	}

	public CuratedPodcast withImage(String image) {
		this.image = image;
		return this;
	}

	public CuratedPodcast withListennotes_url(String url) {
		this.listennotes_url = url;
		return this;
	}

	public CuratedPodcast withPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	public CuratedPodcast withSource_domain(String domain) {
		this.source_domain = domain;
		return this;
	}

	public CuratedPodcast withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	public CuratedPodcast withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(title);
		dest.writeString(image);
		dest.writeString(publisher);
		dest.writeString(thumbnail);
		dest.writeString(source_domain);
		dest.writeString(listennotes_url);
	}
}
