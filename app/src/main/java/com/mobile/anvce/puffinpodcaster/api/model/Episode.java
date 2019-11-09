package com.mobile.anvce.puffinpodcaster.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobile.anvce.puffinpodcaster.util.DateConverter;

import androidx.core.text.HtmlCompat;

public class Episode implements Parcelable {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("audio")
	@Expose
	private String audio;
	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("thumbnail")
	@Expose
	private String thumbnail;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("pub_date_ms")
	@Expose
	private Long pubDateMs;
	@SerializedName("listennotes_url")
	@Expose
	private String listennotesUrl;
	@SerializedName("audio_length_sec")
	@Expose
	private Integer audioLengthSec;
	@SerializedName("explicit_content")
	@Expose
	private Boolean explicitContent;
	@SerializedName("maybe_audio_invalid")
	@Expose
	private Boolean maybeAudioInvalid;
	@SerializedName("listennotes_edit_url")
	@Expose
	private String listennotesEditUrl;

	public boolean isHeader() {
		return isHeader;
	}

	public void setHeader(boolean header) {
		isHeader = header;
	}

	private boolean isHeader;

	public final static Parcelable.Creator<Episode> CREATOR = new Creator<Episode>() {

		@SuppressWarnings({
				"unchecked"
		})
		public Episode createFromParcel(Parcel in) {
			return new Episode(in);
		}

		public Episode[] newArray(int size) {
			return (new Episode[size]);
		}

	};

	protected Episode(Parcel in) {
		this.id = ((String) in.readValue((String.class.getClassLoader())));
		this.audio = ((String) in.readValue((String.class.getClassLoader())));
		this.image = ((String) in.readValue((String.class.getClassLoader())));
		this.title = ((String) in.readValue((String.class.getClassLoader())));
		this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
		this.description = ((String) in.readValue((String.class.getClassLoader())));
		this.pubDateMs = ((Long) in.readValue((Integer.class.getClassLoader())));
		this.listennotesUrl = ((String) in.readValue((String.class.getClassLoader())));
		this.audioLengthSec = ((Integer) in.readValue((Integer.class.getClassLoader())));
		this.explicitContent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
		this.maybeAudioInvalid = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
		this.listennotesEditUrl = ((String) in.readValue((String.class.getClassLoader())));
	}

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Episode() {
	}

	/**
	 *
	 * @param image
	 * @param thumbnail
	 * @param pubDateMs
	 * @param audioLengthSec
	 * @param description
	 * @param maybeAudioInvalid
	 * @param id
	 * @param audio
	 * @param title
	 * @param explicitContent
	 * @param listennotesUrl
	 * @param listennotesEditUrl
	 */
	public Episode(String id, String audio, String image, String title, String thumbnail, String description, Long pubDateMs, String listennotesUrl, Integer audioLengthSec, Boolean explicitContent, Boolean maybeAudioInvalid, String listennotesEditUrl) {
		super();
		this.id = id;
		this.audio = audio;
		this.image = image;
		this.title = title;
		this.thumbnail = thumbnail;
		this.description = description;
		this.pubDateMs = pubDateMs;
		this.listennotesUrl = listennotesUrl;
		this.audioLengthSec = audioLengthSec;
		this.explicitContent = explicitContent;
		this.maybeAudioInvalid = maybeAudioInvalid;
		this.listennotesEditUrl = listennotesEditUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTitle() {
		return isHeader ? "Title" : title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return isHeader ? "Thumbnail" : thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		Spanned text = HtmlCompat.fromHtml(description, 0);
		return text.toString();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPubDateMs() {
		return pubDateMs;
	}

	public void setPubDateMs(Long pubDateMs) {
		this.pubDateMs = pubDateMs;
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

	public Boolean getMaybeAudioInvalid() {
		return maybeAudioInvalid;
	}

	public void setMaybeAudioInvalid(Boolean maybeAudioInvalid) {
		this.maybeAudioInvalid = maybeAudioInvalid;
	}

	public String getListennotesEditUrl() {
		return listennotesEditUrl;
	}

	public void setListennotesEditUrl(String listennotesEditUrl) {
		this.listennotesEditUrl = listennotesEditUrl;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(id);
		dest.writeValue(audio);
		dest.writeValue(image);
		dest.writeValue(title);
		dest.writeValue(thumbnail);
		dest.writeValue(description);
		dest.writeValue(pubDateMs);
		dest.writeValue(listennotesUrl);
		dest.writeValue(audioLengthSec);
		dest.writeValue(explicitContent);
		dest.writeValue(maybeAudioInvalid);
		dest.writeValue(listennotesEditUrl);
	}

	public int describeContents() {
		return 0;
	}

	public String getPubDateMsAsString() {

		return isHeader ? "Published\n Date" : DateConverter.toDate(pubDateMs);
	}

}