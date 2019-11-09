package com.mobile.anvce.puffinpodcaster.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PodcastSearchItem implements Parcelable {

    public final static Parcelable.Creator<PodcastSearchItem> CREATOR = new Creator<PodcastSearchItem>() {

        @SuppressWarnings({
                "unchecked"
        })
        public PodcastSearchItem createFromParcel(Parcel in) {
            return new PodcastSearchItem(in);
        }

        public PodcastSearchItem[] newArray(int size) {
            return (new PodcastSearchItem[size]);
        }

    };
    private long id;
    private String keyword;
    private String description;
    private int resourceId;
    private boolean freeformSearch = true;

    protected PodcastSearchItem(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.keyword = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.resourceId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public PodcastSearchItem(long id, String keyword, String description, int resourceId) {
        this.id = id;
        this.keyword = keyword;
        this.description = description;
        this.resourceId = resourceId;
    }

    public PodcastSearchItem(String keyword, String description, int resourceId) {
        this.keyword = keyword;
        this.description = description;
        this.resourceId = resourceId;
    }

    public PodcastSearchItem(long id, String word) {
        this.id = id;
        this.keyword = word;
    }

    public PodcastSearchItem(long id, String word, String meaning) {
        this.id = id;
        this.keyword = word;
        this.description = meaning;
    }

    public PodcastSearchItem(String word, String meaning,boolean freeFormSearch) {
        this.keyword = word;
        this.description = meaning;
        this.freeformSearch = freeFormSearch;
    }

    public boolean isFreeformSearch() {
        return freeformSearch;
    }

    public void setFreeformSearch(boolean freeformSearch) {
        this.freeformSearch = freeformSearch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(keyword);
        dest.writeValue(description);
        dest.writeValue(resourceId);
    }

    public int getResourceId() {
        return resourceId;
    }

    public long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDescription() {
        return description;
    }
}
