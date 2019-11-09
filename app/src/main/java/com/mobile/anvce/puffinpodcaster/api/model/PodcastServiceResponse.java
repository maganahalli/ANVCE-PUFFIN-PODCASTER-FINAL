package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class PodcastServiceResponse implements Parcelable {

    public final static Parcelable.Creator<PodcastServiceResponse> CREATOR = new Creator<PodcastServiceResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PodcastServiceResponse createFromParcel(Parcel in) {
            return new PodcastServiceResponse(in);
        }

        public PodcastServiceResponse[] newArray(int size) {
            return (new PodcastServiceResponse[size]);
        }

    };
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;
    @SerializedName("podcasts")
    @Expose
    private List<Podcast> podcasts = new ArrayList<Podcast>();
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("page_number")
    @Expose
    private Integer pageNumber;
    @SerializedName("has_previous")
    @Expose
    private Boolean hasPrevious;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("next_page_number")
    @Expose
    private Integer nextPageNumber;
    @SerializedName("previous_page_number")
    @Expose
    private Integer previousPageNumber;

    protected PodcastServiceResponse(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasNext = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.podcasts, (Podcast.class.getClassLoader()));
        this.parentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pageNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasPrevious = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.listennotesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.nextPageNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.previousPageNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public PodcastServiceResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PodcastServiceResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PodcastServiceResponse withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public PodcastServiceResponse withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public PodcastServiceResponse withHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
        return this;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public PodcastServiceResponse withPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public PodcastServiceResponse withParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PodcastServiceResponse withPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public PodcastServiceResponse withHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
        return this;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public PodcastServiceResponse withListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
        return this;
    }

    public Integer getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public PodcastServiceResponse withNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
        return this;
    }

    public Integer getPreviousPageNumber() {
        return previousPageNumber;
    }

    public void setPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }

    public PodcastServiceResponse withPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("total", total).append("hasNext", hasNext).append("podcasts", podcasts).append("parentId", parentId).append("pageNumber", pageNumber).append("hasPrevious", hasPrevious).append("listennotesUrl", listennotesUrl).append("nextPageNumber", nextPageNumber).append("previousPageNumber", previousPageNumber).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(total);
        dest.writeValue(hasNext);
        dest.writeList(podcasts);
        dest.writeValue(parentId);
        dest.writeValue(pageNumber);
        dest.writeValue(hasPrevious);
        dest.writeValue(listennotesUrl);
        dest.writeValue(nextPageNumber);
        dest.writeValue(previousPageNumber);
    }

    public int describeContents() {
        return 0;
    }

}
