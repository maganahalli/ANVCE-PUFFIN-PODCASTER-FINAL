package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedPodcast;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms CuratedPodcast to DbCuratedPodcast.
 */
public class CuratedPodcastFromDbCuratedPodcast extends AnvcePopulatingTransformer<DbCuratedPodcast, CuratedPodcast> {

	@Override
	protected CuratedPodcast createTarget() {
		return new CuratedPodcast();
	}

	@Override
	protected void populateContents(DbCuratedPodcast source, CuratedPodcast target) {
		target.setId(source.getCuratedListId());
		target.setTitle(source.getTitle());
		target.setListennotes_url(source.getListennotes_url());
		target.setSource_domain(source.getSource_domain());
		target.setImage(source.getImage());
		target.setPublisher(source.getPublisher());
		target.setThumbnail(source.getThumbnail());

	}
}
