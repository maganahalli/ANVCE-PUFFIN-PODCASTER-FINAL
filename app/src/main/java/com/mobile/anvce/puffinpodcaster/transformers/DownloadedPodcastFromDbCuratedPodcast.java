package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.DownloadedPodcast;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedPodcast;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms DbCuratedPodcast to DownloadedPodcast.
 */
public class DownloadedPodcastFromDbCuratedPodcast extends AnvcePopulatingTransformer<DbCuratedPodcast, DownloadedPodcast> {

	@Override
	protected DownloadedPodcast createTarget() {
		return new DownloadedPodcast();
	}

	@Override
	protected void populateContents(DbCuratedPodcast source, DownloadedPodcast target) {
		target.setImage(source.getImage());
		target.setTitle(source.getTitle());
		target.setPublisher(source.getPublisher());
	}
}
