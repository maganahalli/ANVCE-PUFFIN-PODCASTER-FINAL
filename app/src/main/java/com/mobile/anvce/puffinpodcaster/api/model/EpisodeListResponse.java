package com.mobile.anvce.puffinpodcaster.api.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EpisodeListResponse implements Parcelable {

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
	@SerializedName("episodes")
	@Expose
	private List<Episode> episodes = new ArrayList<Episode>();
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
	@SerializedName("next_episode_pub_date")
	@Expose
	private Long nextEpisodePubDate;
	public final static Parcelable.Creator<EpisodeListResponse> CREATOR = new Creator<EpisodeListResponse>() {

		@SuppressWarnings({
				"unchecked"
		})
		public EpisodeListResponse createFromParcel(Parcel in) {
			return new EpisodeListResponse(in);
		}

		public EpisodeListResponse[] newArray(int size) {
			return (new EpisodeListResponse[size]);
		}

	};

	protected EpisodeListResponse(Parcel in) {
		this.id = ((String) in.readValue((String.class.getClassLoader())));
		this.rss = ((String) in.readValue((String.class.getClassLoader())));
		this.email = ((String) in.readValue((String.class.getClassLoader())));
		this.extra = ((PodcastExtra) in.readValue((PodcastExtra.class.getClassLoader())));
		this.image = ((String) in.readValue((String.class.getClassLoader())));
		this.title = ((String) in.readValue((String.class.getClassLoader())));
		this.country = ((String) in.readValue((String.class.getClassLoader())));
		this.website = ((String) in.readValue((String.class.getClassLoader())));
		in.readList(this.episodes, (com.mobile.anvce.puffinpodcaster.api.model.Episode.class.getClassLoader()));
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
		this.nextEpisodePubDate = ((Long) in.readValue((Integer.class.getClassLoader())));
	}

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public EpisodeListResponse() {
	}

	/**
	 *
	 * @param image
	 * @param country
	 * @param website
	 * @param thumbnail
	 * @param totalEpisodes
	 * @param description
	 * @param lookingFor
	 * @param language
	 * @param title
	 * @param genreIds
	 * @param explicitContent
	 * @param latestPubDateMs
	 * @param rss
	 * @param earliestPubDateMs
	 * @param extra
	 * @param publisher
	 * @param id
	 * @param isClaimed
	 * @param email
	 * @param episodes
	 * @param itunesId
	 * @param listennotesUrl
	 * @param nextEpisodePubDate
	 */
	public EpisodeListResponse(String id, String rss, String email, PodcastExtra extra, String image, String title, String country, String website, List<Episode> episodes, String language, List<Integer> genreIds, Integer itunesId, String publisher, String thumbnail, Boolean isClaimed, String description, PodcastLookingFor lookingFor, Integer totalEpisodes, String listennotesUrl, Boolean explicitContent, Long latestPubDateMs, Long earliestPubDateMs, Long nextEpisodePubDate) {
		super();
		this.id = id;
		this.rss = rss;
		this.email = email;
		this.extra = extra;
		this.image = image;
		this.title = title;
		this.country = country;
		this.website = website;
		this.episodes = episodes;
		this.language = language;
		this.genreIds = genreIds;
		this.itunesId = itunesId;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.isClaimed = isClaimed;
		this.description = description;
		this.lookingFor = lookingFor;
		this.totalEpisodes = totalEpisodes;
		this.listennotesUrl = listennotesUrl;
		this.explicitContent = explicitContent;
		this.latestPubDateMs = latestPubDateMs;
		this.earliestPubDateMs = earliestPubDateMs;
		this.nextEpisodePubDate = nextEpisodePubDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PodcastExtra getExtra() {
		return extra;
	}

	public void setExtra(PodcastExtra extra) {
		this.extra = extra;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Boolean getIsClaimed() {
		return isClaimed;
	}

	public void setIsClaimed(Boolean isClaimed) {
		this.isClaimed = isClaimed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PodcastLookingFor getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(PodcastLookingFor lookingFor) {
		this.lookingFor = lookingFor;
	}

	public Integer getTotalEpisodes() {
		return totalEpisodes;
	}

	public void setTotalEpisodes(Integer totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	public String getListennotesUrl() {
		return listennotesUrl;
	}

	public void setListennotesUrl(String listennotesUrl) {
		this.listennotesUrl = listennotesUrl;
	}

	public Boolean getExplicitContent() {
		return explicitContent;
	}

	public void setExplicitContent(Boolean explicitContent) {
		this.explicitContent = explicitContent;
	}

	public Long getLatestPubDateMs() {
		return latestPubDateMs;
	}

	public void setLatestPubDateMs(Long latestPubDateMs) {
		this.latestPubDateMs = latestPubDateMs;
	}

	public Long getEarliestPubDateMs() {
		return earliestPubDateMs;
	}

	public void setEarliestPubDateMs(Long earliestPubDateMs) {
		this.earliestPubDateMs = earliestPubDateMs;
	}

	public Long getNextEpisodePubDate() {
		return nextEpisodePubDate;
	}

	public void setNextEpisodePubDate(Long nextEpisodePubDate) {
		this.nextEpisodePubDate = nextEpisodePubDate;
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
		dest.writeList(episodes);
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
		dest.writeValue(nextEpisodePubDate);
	}

	public int describeContents() {
		return 0;
	}

}