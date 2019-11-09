package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PodcastLookingFor implements Parcelable {

    public final static Parcelable.Creator<PodcastLookingFor> CREATOR = new Creator<PodcastLookingFor>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PodcastLookingFor createFromParcel(Parcel in) {
            return new PodcastLookingFor(in);
        }

        public PodcastLookingFor[] newArray(int size) {
            return (new PodcastLookingFor[size]);
        }

    };
    @SerializedName("guests")
    @Expose
    private Boolean guests;
    @SerializedName("cohosts")
    @Expose
    private Boolean cohosts;
    @SerializedName("sponsors")
    @Expose
    private Boolean sponsors;
    @SerializedName("cross_promotion")
    @Expose
    private Boolean crossPromotion;

    protected PodcastLookingFor(Parcel in) {
        this.guests = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.cohosts = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.sponsors = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.crossPromotion = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public PodcastLookingFor() {
    }

    public Boolean getGuests() {
        return guests;
    }

    public void setGuests(Boolean guests) {
        this.guests = guests;
    }

    public PodcastLookingFor withGuests(Boolean guests) {
        this.guests = guests;
        return this;
    }

    public Boolean getCohosts() {
        return cohosts;
    }

    public void setCohosts(Boolean cohosts) {
        this.cohosts = cohosts;
    }

    public PodcastLookingFor withCohosts(Boolean cohosts) {
        this.cohosts = cohosts;
        return this;
    }

    public Boolean getSponsors() {
        return sponsors;
    }

    public void setSponsors(Boolean sponsors) {
        this.sponsors = sponsors;
    }

    public PodcastLookingFor withSponsors(Boolean sponsors) {
        this.sponsors = sponsors;
        return this;
    }

    public Boolean getCrossPromotion() {
        return crossPromotion;
    }

    public void setCrossPromotion(Boolean crossPromotion) {
        this.crossPromotion = crossPromotion;
    }

    public PodcastLookingFor withCrossPromotion(Boolean crossPromotion) {
        this.crossPromotion = crossPromotion;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("guests", guests).append("cohosts", cohosts).append("sponsors", sponsors).append("crossPromotion", crossPromotion).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(guests);
        dest.writeValue(cohosts);
        dest.writeValue(sponsors);
        dest.writeValue(crossPromotion);
    }

    public int describeContents() {
        return 0;
    }

}