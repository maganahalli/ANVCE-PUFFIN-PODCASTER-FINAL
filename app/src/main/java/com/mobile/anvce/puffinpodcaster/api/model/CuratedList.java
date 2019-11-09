package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CuratedList implements Parcelable {

    public static final Creator<CuratedList> CREATOR = new Creator<CuratedList>() {
        @Override
        public CuratedList createFromParcel(Parcel in) {
            return new CuratedList(in);
        }

        @Override
        public CuratedList[] newArray(int size) {
            return new CuratedList[size];
        }
    };
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("podcasts")
    @Expose
    private List<CuratedPodcast> podcasts = new ArrayList<CuratedPodcast>();
    @SerializedName("source_url")
    @Expose
    private String source_url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pub_date_ms")
    @Expose
    private String pub_date_ms;
    @SerializedName("source_domain")
    @Expose
    private String source_domain;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotes_url;

    public CuratedList(String id, String title, List<CuratedPodcast> podcasts, String source_url, String description, String pub_date_ms, String source_domain, String listennotes_url) {
        this.id = id;
        this.title = title;
        this.podcasts = podcasts;
        this.source_url = source_url;
        this.description = description;
        this.pub_date_ms = pub_date_ms;
        this.source_domain = source_domain;
        this.listennotes_url = listennotes_url;
    }

    public CuratedList() {

    }

    protected CuratedList(Parcel in) {
        id = in.readString();
        title = in.readString();
        in.readList(this.podcasts, (CuratedPodcast.class.getClassLoader()));
        source_url = in.readString();
        description = in.readString();
        pub_date_ms = in.readString();
        source_domain = in.readString();
        listennotes_url = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CuratedList withId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CuratedList withTitle(String title) {
        this.title = title;
        return this;
    }

    public List<CuratedPodcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<CuratedPodcast> podcasts) {
        this.podcasts = podcasts;
    }

    public CuratedList withPodcasts(List<CuratedPodcast> list) {
        this.podcasts = list;
        return this;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public CuratedList withSource_url(String url) {
        this.source_url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CuratedList withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPub_date_ms() {
        return pub_date_ms;
    }

    public void setPub_date_ms(String pub_date_ms) {
        this.pub_date_ms = pub_date_ms;
    }

    public CuratedList withPub_date_ms(String date_ms) {
        this.pub_date_ms = date_ms;
        return this;
    }

    public String getSource_domain() {
        return source_domain;
    }

    public void setSource_domain(String source_domain) {
        this.source_domain = source_domain;
    }

    public CuratedList withSource_domain(String domain) {
        this.source_domain = domain;
        return this;
    }

    public String getListennotes_url() {
        return listennotes_url;
    }

    public void setListennotes_url(String listennotes_url) {
        this.listennotes_url = listennotes_url;
    }

    public CuratedList withListennotes_url(String url) {
        this.listennotes_url = url;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeList(podcasts);
        dest.writeString(source_url);
        dest.writeString(description);
        dest.writeString(pub_date_ms);
        dest.writeString(source_domain);
        dest.writeString(listennotes_url);
    }
}
