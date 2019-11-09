package com.mobile.anvce.puffinpodcaster.database;

import com.mobile.anvce.puffinpodcaster.util.DateConverter;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Models Episode for Room Database
 * @author Venkatesh Maganahalli
 */
@Entity(tableName = "LISTENING_HISTORY_TABLE")
public class DbListeningHistory {

	private String audio;
	private Integer audioLengthSec;
	private String description;
	private String episodeId;
	private Boolean explicitContent;
	@NonNull
	@PrimaryKey(autoGenerate = true)
	private int id;
	private String image;
	private String listennotesEditUrl;
	private String listennotesUrl;
	private Boolean maybeAudioInvalid;
	private Long pubDateMs;
	private String thumbnail;
	private String title;
	private String category;

	public DbListeningHistory(int id, String episodeId, String audio, String image, String title, String thumbnail, String description, Long pubDateMs, String listennotesUrl, Integer audioLengthSec, Boolean explicitContent, Boolean maybeAudioInvalid, String listennotesEditUrl, String category) {
		this.id = id;
		this.episodeId = episodeId;
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
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Ignore
	public DbListeningHistory() {
	}

	public int describeContents() {
		return 0;
	}

	public String getAudio() {
		return audio;
	}

	public Integer getAudioLengthSec() {
		return audioLengthSec;
	}

	public String getDescription() {
		return description;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public Boolean getExplicitContent() {
		return explicitContent;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getListennotesEditUrl() {
		return listennotesEditUrl;
	}

	public String getListennotesUrl() {
		return listennotesUrl;
	}

	public Boolean getMaybeAudioInvalid() {
		return maybeAudioInvalid;
	}

	public Long getPubDateMs() {
		return pubDateMs;
	}

	public String getPubDateMsAsString() {
		return DateConverter.toDate(pubDateMs);
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public void setAudioLengthSec(Integer audioLengthSec) {
		this.audioLengthSec = audioLengthSec;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public void setExplicitContent(Boolean explicitContent) {
		this.explicitContent = explicitContent;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setListennotesEditUrl(String listennotesEditUrl) {
		this.listennotesEditUrl = listennotesEditUrl;
	}

	public void setListennotesUrl(String listennotesUrl) {
		this.listennotesUrl = listennotesUrl;
	}

	public void setMaybeAudioInvalid(Boolean maybeAudioInvalid) {
		this.maybeAudioInvalid = maybeAudioInvalid;
	}

	public void setPubDateMs(Long pubDateMs) {
		this.pubDateMs = pubDateMs;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}