package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobile.anvce.puffinpodcaster.R;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;

public class SearchResultByKeyWord implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rss")
    @Expose
    private String rss;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("itunes_id")
    @Expose
    private Integer itunesId;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("podcast_id")
    @Expose
    private String podcastId;
    @SerializedName("pub_date_ms")
    @Expose
    private Integer pubDateMs;
    @SerializedName("title_original")
    @Expose
    private String titleOriginal;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("audio_length_sec")
    @Expose
    private Integer audioLengthSec;
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("title_highlighted")
    @Expose
    private String titleHighlighted;
    @SerializedName("publisher_original")
    @Expose
    private String publisherOriginal;
    @SerializedName("description_original")
    @Expose
    private String descriptionOriginal;
    @SerializedName("publisher_highlighted")
    @Expose
    private String publisherHighlighted;
    @SerializedName("podcast_title_original")
    @Expose
    private String podcastTitleOriginal;
    @SerializedName("description_highlighted")
    @Expose
    private String descriptionHighlighted;
    @SerializedName("podcast_listennotes_url")
    @Expose
    private String podcastListennotesUrl;
    @SerializedName("transcripts_highlighted")
    @Expose
    private List<Object> transcriptsHighlighted = new ArrayList<Object>();
    @SerializedName("podcast_title_highlighted")
    @Expose
    private String podcastTitleHighlighted;
    public final static Parcelable.Creator<SearchResultByKeyWord> CREATOR = new Creator<SearchResultByKeyWord>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResultByKeyWord createFromParcel(Parcel in) {
            return new SearchResultByKeyWord(in);
        }

        public SearchResultByKeyWord[] newArray(int size) {
            return (new SearchResultByKeyWord[size]);
        }

    }
            ;

    protected SearchResultByKeyWord(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.rss = ((String) in.readValue((String.class.getClassLoader())));
        this.audio = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.genreIds, (java.lang.Integer.class.getClassLoader()));
        this.itunesId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
        this.podcastId = ((String) in.readValue((String.class.getClassLoader())));
        this.pubDateMs = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.titleOriginal = ((String) in.readValue((String.class.getClassLoader())));
        this.listennotesUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.audioLengthSec = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.explicitContent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.titleHighlighted = ((String) in.readValue((String.class.getClassLoader())));
        this.publisherOriginal = ((String) in.readValue((String.class.getClassLoader())));
        this.descriptionOriginal = ((String) in.readValue((String.class.getClassLoader())));
        this.publisherHighlighted = ((String) in.readValue((String.class.getClassLoader())));
        this.podcastTitleOriginal = ((String) in.readValue((String.class.getClassLoader())));
        this.descriptionHighlighted = ((String) in.readValue((String.class.getClassLoader())));
        this.podcastListennotesUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.transcriptsHighlighted, (java.lang.Object.class.getClassLoader()));
        this.podcastTitleHighlighted = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public SearchResultByKeyWord() {
    }

    /**
     *
     * @param image
     * @param podcastId
     * @param descriptionOriginal
     * @param thumbnail
     * @param pubDateMs
     * @param podcastListennotesUrl
     * @param transcriptsHighlighted
     * @param titleHighlighted
     * @param genreIds
     * @param titleOriginal
     * @param explicitContent
     * @param publisherHighlighted
     * @param podcastTitleOriginal
     * @param rss
     * @param publisherOriginal
     * @param podcastTitleHighlighted
     * @param audioLengthSec
     * @param id
     * @param audio
     * @param itunesId
     * @param listennotesUrl
     * @param descriptionHighlighted
     */
    public SearchResultByKeyWord(String id, String rss, String audio, String image, List<Integer> genreIds, Integer itunesId, String thumbnail, String podcastId, Integer pubDateMs, String titleOriginal, String listennotesUrl, Integer audioLengthSec, Boolean explicitContent, String titleHighlighted, String publisherOriginal, String descriptionOriginal, String publisherHighlighted, String podcastTitleOriginal, String descriptionHighlighted, String podcastListennotesUrl, List<Object> transcriptsHighlighted, String podcastTitleHighlighted) {
        super();
        this.id = id;
        this.rss = rss;
        this.audio = audio;
        this.image = image;
        this.genreIds = genreIds;
        this.itunesId = itunesId;
        this.thumbnail = thumbnail;
        this.podcastId = podcastId;
        this.pubDateMs = pubDateMs;
        this.titleOriginal = titleOriginal;
        this.listennotesUrl = listennotesUrl;
        this.audioLengthSec = audioLengthSec;
        this.explicitContent = explicitContent;
        this.titleHighlighted = titleHighlighted;
        this.publisherOriginal = publisherOriginal;
        this.descriptionOriginal = descriptionOriginal;
        this.publisherHighlighted = publisherHighlighted;
        this.podcastTitleOriginal = podcastTitleOriginal;
        this.descriptionHighlighted = descriptionHighlighted;
        this.podcastListennotesUrl = podcastListennotesUrl;
        this.transcriptsHighlighted = transcriptsHighlighted;
        this.podcastTitleHighlighted = podcastTitleHighlighted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public Integer getPubDateMs() {
        return pubDateMs;
    }

    public void setPubDateMs(Integer pubDateMs) {
        this.pubDateMs = pubDateMs;
    }

    public String getTitleOriginal() {
        return titleOriginal;
    }

    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public Integer getAudioLengthSec() {
        return audioLengthSec;
    }

    public void setAudioLengthSec(Integer audioLengthSec) {
        this.audioLengthSec = audioLengthSec;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getTitleHighlighted() {
        return titleHighlighted;
    }

    public void setTitleHighlighted(String titleHighlighted) {
        this.titleHighlighted = titleHighlighted;
    }

    public String getPublisherOriginal() {
        return publisherOriginal;
    }

    public void setPublisherOriginal(String publisherOriginal) {
        this.publisherOriginal = publisherOriginal;
    }

    public String getDescriptionOriginal() {
        return descriptionOriginal;
    }

    public void setDescriptionOriginal(String descriptionOriginal) {
        this.descriptionOriginal = descriptionOriginal;
    }

    public String getPublisherHighlighted() {
        return publisherHighlighted;
    }

    public void setPublisherHighlighted(String publisherHighlighted) {
        this.publisherHighlighted = publisherHighlighted;
    }

    public String getPodcastTitleOriginal() {
        return podcastTitleOriginal;
    }

    public void setPodcastTitleOriginal(String podcastTitleOriginal) {
        this.podcastTitleOriginal = podcastTitleOriginal;
    }

    public String getDescriptionHighlighted() {
        return descriptionHighlighted;
    }

    public void setDescriptionHighlighted(String descriptionHighlighted) {
        this.descriptionHighlighted = descriptionHighlighted;
    }

    public String getPodcastListennotesUrl() {
        return podcastListennotesUrl;
    }

    public void setPodcastListennotesUrl(String podcastListennotesUrl) {
        this.podcastListennotesUrl = podcastListennotesUrl;
    }

    public List<Object> getTranscriptsHighlighted() {
        return transcriptsHighlighted;
    }

    public void setTranscriptsHighlighted(List<Object> transcriptsHighlighted) {
        this.transcriptsHighlighted = transcriptsHighlighted;
    }

    public String getPodcastTitleHighlighted() {
        return podcastTitleHighlighted;
    }

    public void setPodcastTitleHighlighted(String podcastTitleHighlighted) {
        this.podcastTitleHighlighted = podcastTitleHighlighted;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(rss);
        dest.writeValue(audio);
        dest.writeValue(image);
        dest.writeList(genreIds);
        dest.writeValue(itunesId);
        dest.writeValue(thumbnail);
        dest.writeValue(podcastId);
        dest.writeValue(pubDateMs);
        dest.writeValue(titleOriginal);
        dest.writeValue(listennotesUrl);
        dest.writeValue(audioLengthSec);
        dest.writeValue(explicitContent);
        dest.writeValue(titleHighlighted);
        dest.writeValue(publisherOriginal);
        dest.writeValue(descriptionOriginal);
        dest.writeValue(publisherHighlighted);
        dest.writeValue(podcastTitleOriginal);
        dest.writeValue(descriptionHighlighted);
        dest.writeValue(podcastListennotesUrl);
        dest.writeList(transcriptsHighlighted);
        dest.writeValue(podcastTitleHighlighted);
    }

    public int describeContents() {
        return 0;
    }

}