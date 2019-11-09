package com.mobile.anvce.puffinpodcaster.api.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CuratedPodcastServiceResponse implements Parcelable {

    public final static Creator<CuratedPodcastServiceResponse> CREATOR = new Creator<CuratedPodcastServiceResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CuratedPodcastServiceResponse createFromParcel(Parcel in) {
            return new CuratedPodcastServiceResponse(in);
        }

        public CuratedPodcastServiceResponse[] newArray(int size) {
            return (new CuratedPodcastServiceResponse[size]);
        }

    };

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;
    @SerializedName("curated_lists")
    @Expose
    private List<CuratedList> curatedLists = new ArrayList<CuratedList>();

    @SerializedName("page_number")
    @Expose
    private Integer pageNumber;
    @SerializedName("has_previous")
    @Expose
    private Boolean hasPrevious;

    @SerializedName("next_page_number")
    @Expose
    private Integer nextPageNumber;
    @SerializedName("previous_page_number")
    @Expose
    private Integer previousPageNumber;

    protected CuratedPodcastServiceResponse(Parcel in) {
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasNext = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.curatedLists, (CuratedList.class.getClassLoader()));
        this.pageNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasPrevious = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.nextPageNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.previousPageNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CuratedPodcastServiceResponse() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public CuratedPodcastServiceResponse withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public CuratedPodcastServiceResponse withHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
        return this;
    }

    public List<CuratedList> getCuratedLists() {
        return curatedLists;
    }

    public void setCuratedLists(List<CuratedList> curatedLists) {
        this.curatedLists = curatedLists;
    }

    public CuratedPodcastServiceResponse withPodcasts(List<CuratedList> podcasts) {
        this.curatedLists = podcasts;
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public CuratedPodcastServiceResponse withPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public CuratedPodcastServiceResponse withHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
        return this;
    }

    public Integer getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public CuratedPodcastServiceResponse withNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
        return this;
    }

    public Integer getPreviousPageNumber() {
        return previousPageNumber;
    }

    public void setPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }

    public CuratedPodcastServiceResponse withPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("total", total).append("hasNext", hasNext).append("curatedLists", curatedLists).append("pageNumber", pageNumber).append("hasPrevious", hasPrevious).append("nextPageNumber", nextPageNumber).append("previousPageNumber", previousPageNumber).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(hasNext);
        dest.writeList(curatedLists);
        dest.writeValue(pageNumber);
        dest.writeValue(hasPrevious);
        dest.writeValue(nextPageNumber);
        dest.writeValue(previousPageNumber);
    }

    public int describeContents() {
        return 0;
    }

}
