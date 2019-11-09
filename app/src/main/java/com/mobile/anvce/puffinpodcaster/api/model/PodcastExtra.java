package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PodcastExtra implements Parcelable {

    public final static Parcelable.Creator<PodcastExtra> CREATOR = new Creator<PodcastExtra>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PodcastExtra createFromParcel(Parcel in) {
            return new PodcastExtra(in);
        }

        public PodcastExtra[] newArray(int size) {
            return (new PodcastExtra[size]);
        }

    };
    @SerializedName("url1")
    @Expose
    private String url1;
    @SerializedName("url2")
    @Expose
    private String url2;
    @SerializedName("url3")
    @Expose
    private String url3;
    @SerializedName("google_url")
    @Expose
    private String googleUrl;
    @SerializedName("spotify_url")
    @Expose
    private String spotifyUrl;
    @SerializedName("youtube_url")
    @Expose
    private String youtubeUrl;
    @SerializedName("linkedin_url")
    @Expose
    private String linkedinUrl;
    @SerializedName("wechat_handle")
    @Expose
    private String wechatHandle;
    @SerializedName("patreon_handle")
    @Expose
    private String patreonHandle;
    @SerializedName("twitter_handle")
    @Expose
    private String twitterHandle;
    @SerializedName("facebook_handle")
    @Expose
    private String facebookHandle;
    @SerializedName("instagram_handle")
    @Expose
    private String instagramHandle;

    protected PodcastExtra(Parcel in) {
        this.url1 = ((String) in.readValue((String.class.getClassLoader())));
        this.url2 = ((String) in.readValue((String.class.getClassLoader())));
        this.url3 = ((String) in.readValue((String.class.getClassLoader())));
        this.googleUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.spotifyUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.youtubeUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.linkedinUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.wechatHandle = ((String) in.readValue((String.class.getClassLoader())));
        this.patreonHandle = ((String) in.readValue((String.class.getClassLoader())));
        this.twitterHandle = ((String) in.readValue((String.class.getClassLoader())));
        this.facebookHandle = ((String) in.readValue((String.class.getClassLoader())));
        this.instagramHandle = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PodcastExtra() {
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public PodcastExtra withUrl1(String url1) {
        this.url1 = url1;
        return this;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public PodcastExtra withUrl2(String url2) {
        this.url2 = url2;
        return this;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public PodcastExtra withUrl3(String url3) {
        this.url3 = url3;
        return this;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public PodcastExtra withGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
        return this;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    public void setSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
    }

    public PodcastExtra withSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
        return this;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public PodcastExtra withYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
        return this;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public PodcastExtra withLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
        return this;
    }

    public String getWechatHandle() {
        return wechatHandle;
    }

    public void setWechatHandle(String wechatHandle) {
        this.wechatHandle = wechatHandle;
    }

    public PodcastExtra withWechatHandle(String wechatHandle) {
        this.wechatHandle = wechatHandle;
        return this;
    }

    public String getPatreonHandle() {
        return patreonHandle;
    }

    public void setPatreonHandle(String patreonHandle) {
        this.patreonHandle = patreonHandle;
    }

    public PodcastExtra withPatreonHandle(String patreonHandle) {
        this.patreonHandle = patreonHandle;
        return this;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public PodcastExtra withTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
        return this;
    }

    public String getFacebookHandle() {
        return facebookHandle;
    }

    public void setFacebookHandle(String facebookHandle) {
        this.facebookHandle = facebookHandle;
    }

    public PodcastExtra withFacebookHandle(String facebookHandle) {
        this.facebookHandle = facebookHandle;
        return this;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    public PodcastExtra withInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url1", url1).append("url2", url2).append("url3", url3).append("googleUrl", googleUrl).append("spotifyUrl", spotifyUrl).append("youtubeUrl", youtubeUrl).append("linkedinUrl", linkedinUrl).append("wechatHandle", wechatHandle).append("patreonHandle", patreonHandle).append("twitterHandle", twitterHandle).append("facebookHandle", facebookHandle).append("instagramHandle", instagramHandle).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url1);
        dest.writeValue(url2);
        dest.writeValue(url3);
        dest.writeValue(googleUrl);
        dest.writeValue(spotifyUrl);
        dest.writeValue(youtubeUrl);
        dest.writeValue(linkedinUrl);
        dest.writeValue(wechatHandle);
        dest.writeValue(patreonHandle);
        dest.writeValue(twitterHandle);
        dest.writeValue(facebookHandle);
        dest.writeValue(instagramHandle);
    }

    public int describeContents() {
        return 0;
    }

}