package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.DbPodcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms DbPodcast to Podcast.
 */
public class PodcastFromDbPodcast extends AnvcePopulatingTransformer<DbPodcast, Podcast> {

	@Override
	protected Podcast createTarget() {
		return new Podcast();
	}

	@Override
	protected void populateContents(DbPodcast source, Podcast target) {
		target.setId(source.getPodcastId());
		target.setIsClaimed(source.getClaimed());
		target.setCountry(source.getCountry());
		target.setDescription(source.getDescription());
		target.setEmail(source.getEmail());
		target.setEarliestPubDateMs(source.getEarliestPubDateMs());
		target.setExplicitContent(source.getExplicitContent());
		target.setImage(source.getImage());
		target.setItunesId(source.getItunesId());
		target.setLanguage(source.getLanguage());
		target.setLatestPubDateMs(source.getLatestPubDateMs());
		target.setListennotesUrl(source.getListennotesUrl());
		target.setPublisher(source.getPublisher());
		target.setRss(source.getRss());
		target.setThumbnail(source.getThumbnail());
		target.setTitle(source.getTitle());
		target.setTotalEpisodes(source.getTotalEpisodes());
		target.setWebsite(source.getWebsite());
		target.setGenreIds(new PodcastCustomDataConverter().toGenreIds(source.getGenreIdsAsString()));
		target.setPodcastExtra(new PodcastCustomDataConverter().toPodcastExtra(source.getPodcastExtraAsString()));
		target.setLookingFor(new PodcastCustomDataConverter().toPodcastLookingFor(source.getPodcastLookingForAsString()));
	}
}
