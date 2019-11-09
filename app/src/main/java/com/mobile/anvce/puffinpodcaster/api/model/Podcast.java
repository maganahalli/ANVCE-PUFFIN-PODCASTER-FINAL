package com.mobile.anvce.puffinpodcaster.api.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobile.anvce.puffinpodcaster.R;

import org.apache.commons.lang3.builder.ToStringBuilder;

import androidx.databinding.BindingAdapter;

public class Podcast implements Parcelable {

	public final static Parcelable.Creator<Podcast> CREATOR = new Creator<Podcast>() {

		@SuppressWarnings({
				"unchecked"
		})
		public Podcast createFromParcel(Parcel in) {
			return new Podcast(in);
		}

		public Podcast[] newArray(int size) {
			return (new Podcast[size]);
		}

	};
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("rss")
	@Expose
	private String rss;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("extra")
	@Expose
	private PodcastExtra extra;
	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("website")
	@Expose
	private String website;
	@SerializedName("language")
	@Expose
	private String language;
	@SerializedName("genre_ids")
	@Expose
	private List<Integer> genreIds = new ArrayList<Integer>();
	@SerializedName("itunes_id")
	@Expose
	private Integer itunesId;
	@SerializedName("publisher")
	@Expose
	private String publisher;
	@SerializedName("thumbnail")
	@Expose
	private String thumbnail;
	@SerializedName("is_claimed")
	@Expose
	private Boolean isClaimed;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("looking_for")
	@Expose
	private PodcastLookingFor lookingFor;
	@SerializedName("total_episodes")
	@Expose
	private Integer totalEpisodes;
	@SerializedName("listennotes_url")
	@Expose
	private String listennotesUrl;
	@SerializedName("explicit_content")
	@Expose
	private Boolean explicitContent;
	@SerializedName("latest_pub_date_ms")
	@Expose
	private Long latestPubDateMs;
	@SerializedName("earliest_pub_date_ms")
	@Expose
	private Long earliestPubDateMs;

	protected Podcast(Parcel in) {
		this.id = ((String) in.readValue((String.class.getClassLoader())));
		this.rss = ((String) in.readValue((String.class.getClassLoader())));
		this.email = ((String) in.readValue((String.class.getClassLoader())));
		this.extra = ((PodcastExtra) in.readValue((PodcastExtra.class.getClassLoader())));
		this.image = ((String) in.readValue((String.class.getClassLoader())));
		this.title = ((String) in.readValue((String.class.getClassLoader())));
		this.country = ((String) in.readValue((String.class.getClassLoader())));
		this.website = ((String) in.readValue((String.class.getClassLoader())));
		this.language = ((String) in.readValue((String.class.getClassLoader())));
		in.readList(this.genreIds, (java.lang.Integer.class.getClassLoader()));
		this.itunesId = ((Integer) in.readValue((Integer.class.getClassLoader())));
		this.publisher = ((String) in.readValue((String.class.getClassLoader())));
		this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
		this.isClaimed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
		this.description = ((String) in.readValue((String.class.getClassLoader())));
		this.lookingFor = ((PodcastLookingFor) in.readValue((PodcastLookingFor.class.getClassLoader())));
		this.totalEpisodes = ((Integer) in.readValue((Integer.class.getClassLoader())));
		this.listennotesUrl = ((String) in.readValue((String.class.getClassLoader())));
		this.explicitContent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
		this.latestPubDateMs = ((Long) in.readValue((Integer.class.getClassLoader())));
		this.earliestPubDateMs = ((Long) in.readValue((Integer.class.getClassLoader())));
	}

	public Podcast() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Podcast withId(String id) {
		this.id = id;
		return this;
	}

	public String getRss() {
		return rss;
	}

	public void setRss(String rss) {
		this.rss = rss;
	}

	public Podcast withRss(String rss) {
		this.rss = rss;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Podcast withEmail(String email) {
		this.email = email;
		return this;
	}

	public PodcastExtra getPodcastExtra() {
		return extra;
	}

	public void setPodcastExtra(PodcastExtra podcastExtra) {
		this.extra = podcastExtra;
	}

	public Podcast withExtra(PodcastExtra podcastExtra) {
		this.extra = podcastExtra;
		return this;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Podcast withImage(String image) {
		this.image = image;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Podcast withTitle(String title) {
		this.title = title;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Podcast withCountry(String country) {
		this.country = country;
		return this;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Podcast withWebsite(String website) {
		this.website = website;
		return this;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Podcast withLanguage(String language) {
		this.language = language;
		return this;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public Podcast withGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
		return this;
	}

	public Integer getItunesId() {
		return itunesId;
	}

	public void setItunesId(Integer itunesId) {
		this.itunesId = itunesId;
	}

	public Podcast withItunesId(Integer itunesId) {
		this.itunesId = itunesId;
		return this;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Podcast withPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Podcast withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	public Boolean getIsClaimed() {
		return isClaimed;
	}

	public void setIsClaimed(Boolean isClaimed) {
		this.isClaimed = isClaimed;
	}

	public Podcast withIsClaimed(Boolean isClaimed) {
		this.isClaimed = isClaimed;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Podcast withDescription(String description) {
		this.description = description;
		return this;
	}

	public PodcastLookingFor getPodcastLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(PodcastLookingFor podcastLookingFor) {
		this.lookingFor = podcastLookingFor;
	}

	public Podcast withLookingFor(PodcastLookingFor podcastLookingFor) {
		this.lookingFor = podcastLookingFor;
		return this;
	}

	public Integer getTotalEpisodes() {
		return totalEpisodes;
	}

	public void setTotalEpisodes(Integer totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	public Podcast withTotalEpisodes(Integer totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
		return this;
	}

	public String getListennotesUrl() {
		return listennotesUrl;
	}

	public void setListennotesUrl(String listennotesUrl) {
		this.listennotesUrl = listennotesUrl;
	}

	public Podcast withListennotesUrl(String listennotesUrl) {
		this.listennotesUrl = listennotesUrl;
		return this;
	}

	public Boolean getExplicitContent() {
		return explicitContent;
	}

	public void setExplicitContent(Boolean explicitContent) {
		this.explicitContent = explicitContent;
	}

	public Podcast withExplicitContent(Boolean explicitContent) {
		this.explicitContent = explicitContent;
		return this;
	}

	public Long getLatestPubDateMs() {
		return latestPubDateMs;
	}

	public void setLatestPubDateMs(Long latestPubDateMs) {
		this.latestPubDateMs = latestPubDateMs;
	}

	public Podcast withLatestPubDateMs(Long latestPubDateMs) {
		this.latestPubDateMs = latestPubDateMs;
		return this;
	}

	public Long getEarliestPubDateMs() {
		return earliestPubDateMs;
	}

	public void setEarliestPubDateMs(Long earliestPubDateMs) {
		this.earliestPubDateMs = earliestPubDateMs;
	}

	public Podcast withEarliestPubDateMs(Long earliestPubDateMs) {
		this.earliestPubDateMs = earliestPubDateMs;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("rss", rss).append("email", email).append("extra", extra).append("image", image).append("title", title).append("country", country).append("website", website).append("language", language).append("genreIds", genreIds).append("itunesId", itunesId).append("publisher", publisher).append("thumbnail", thumbnail).append("isClaimed", isClaimed).append("description", description).append("looking_for", lookingFor).append("totalEpisodes", totalEpisodes).append("listennotesUrl", listennotesUrl).append("explicitContent", explicitContent).append("latestPubDateMs", latestPubDateMs).append("earliestPubDateMs", earliestPubDateMs).toString();
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(id);
		dest.writeValue(rss);
		dest.writeValue(email);
		dest.writeValue(extra);
		dest.writeValue(image);
		dest.writeValue(title);
		dest.writeValue(country);
		dest.writeValue(website);
		dest.writeValue(language);
		dest.writeList(genreIds);
		dest.writeValue(itunesId);
		dest.writeValue(publisher);
		dest.writeValue(thumbnail);
		dest.writeValue(isClaimed);
		dest.writeValue(description);
		dest.writeValue(lookingFor);
		dest.writeValue(totalEpisodes);
		dest.writeValue(listennotesUrl);
		dest.writeValue(explicitContent);
		dest.writeValue(latestPubDateMs);
		dest.writeValue(earliestPubDateMs);
	}

	public int describeContents() {
		return 0;
	}



}