package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedList;
import com.mobile.anvce.puffinpodcaster.database.DbPodcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms CuratedList to DbCuratedList.
 */
public class DbCuratedListFromCuratedList extends AnvcePopulatingTransformer<CuratedList, DbCuratedList> {

    @Override
    protected DbCuratedList createTarget() {
        return new DbCuratedList();
    }

    @Override
    protected void populateContents(CuratedList source, DbCuratedList target) {
        target.setCuratedListId(source.getId());
        target.setDescription(source.getDescription());
        target.setTitle(source.getTitle());
        target.setListennotes_url(source.getListennotes_url());
        target.setPub_date_ms(source.getPub_date_ms());
        target.setSource_domain(source.getSource_domain());
        target.setSource_url(source.getSource_url());
        target.setCuaratedPodcastsListAsString(new PodcastCustomDataConverter().fromCuratedPodcastList(source.getPodcasts()));

    }
}
