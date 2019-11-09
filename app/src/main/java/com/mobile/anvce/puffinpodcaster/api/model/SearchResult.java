package com.mobile.anvce.puffinpodcaster.api.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult implements Parcelable
{

    @SerializedName("took")
    @Expose
    private Double took;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("results")
    @Expose
    private List<SearchResultByKeyWord> results = new ArrayList<SearchResultByKeyWord>();
    @SerializedName("next_offset")
    @Expose
    private Integer nextOffset;
    public final static Parcelable.Creator<SearchResult> CREATOR = new Creator<SearchResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        public SearchResult[] newArray(int size) {
            return (new SearchResult[size]);
        }

    }
            ;

    protected SearchResult(Parcel in) {
        this.took = ((Double) in.readValue((Double.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (SearchResultByKeyWord.class.getClassLoader()));
        this.nextOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public SearchResult() {
    }

    /**
     *
     * @param took
     * @param total
     * @param count
     * @param nextOffset
     * @param results
     */
    public SearchResult(Double took, Integer count, Integer total, List<SearchResultByKeyWord> results, Integer nextOffset) {
        super();
        this.took = took;
        this.count = count;
        this.total = total;
        this.results = results;
        this.nextOffset = nextOffset;
    }

    public Double getTook() {
        return took;
    }

    public void setTook(Double took) {
        this.took = took;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<SearchResultByKeyWord> getResults() {
        return results;
    }

    public void setResults(List<SearchResultByKeyWord> results) {
        this.results = results;
    }

    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(took);
        dest.writeValue(count);
        dest.writeValue(total);
        dest.writeList(results);
        dest.writeValue(nextOffset);
    }

    public int describeContents() {
        return 0;
    }

}
