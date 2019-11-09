package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.DbPodcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms Podcast to DbPodcast.
 */
public class DbPodcastFromPodcast extends AnvcePopulatingTransformer<Podcast, DbPodcast> {

    @Override
    protected DbPodcast createTarget() {
        return new DbPodcast();
    }

    @Override
    protected void populateContents(Podcast source, DbPodcast target) {
        target.setPodcastId(source.getId());
        target.setClaimed(source.getIsClaimed());
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
        target.setGenreIdsAsString(new PodcastCustomDataConverter().fromGenreIds(source.getGenreIds()));
        target.setPodcastExtraAsString(new PodcastCustomDataConverter().fromPodcastExtra(source.getPodcastExtra()));
        target.setPodcastLookingForAsString(new PodcastCustomDataConverter().fromPodcastLookingFor(source.getPodcastLookingFor()));
    }
}
