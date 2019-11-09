package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedList;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedPodcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms CuratedPodcast to DbCuratedPodcast.
 */
public class DbCuratedPodcastFromCuratedPodcast extends AnvcePopulatingTransformer<CuratedPodcast, DbCuratedPodcast> {

    @Override
    protected DbCuratedPodcast createTarget() {
        return new DbCuratedPodcast();
    }

    @Override
    protected void populateContents(CuratedPodcast source, DbCuratedPodcast target) {
        target.setCuratedListId(source.getId());
        target.setTitle(source.getTitle());
        target.setListennotes_url(source.getListennotes_url());
        target.setSource_domain(source.getSource_domain());
        target.setImage(source.getImage());
        target.setPublisher(source.getPublisher());
        target.setThumbnail(source.getThumbnail());


    }
}
