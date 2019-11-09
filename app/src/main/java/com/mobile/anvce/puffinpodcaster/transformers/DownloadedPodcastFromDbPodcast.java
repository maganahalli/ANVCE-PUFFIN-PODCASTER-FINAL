package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.DownloadedPodcast;
import com.mobile.anvce.puffinpodcaster.database.DbPodcast;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms DbPodcast to DownloadedPodcast.
 */
public class DownloadedPodcastFromDbPodcast extends AnvcePopulatingTransformer<DbPodcast, DownloadedPodcast> {

	@Override
	protected DownloadedPodcast createTarget() {
		return new DownloadedPodcast();
	}

	@Override
	protected void populateContents(DbPodcast source, DownloadedPodcast target) {
		target.setImage(source.getImage());
		target.setTitle(source.getTitle());
		target.setPublisher(source.getPublisher());
	}
}
