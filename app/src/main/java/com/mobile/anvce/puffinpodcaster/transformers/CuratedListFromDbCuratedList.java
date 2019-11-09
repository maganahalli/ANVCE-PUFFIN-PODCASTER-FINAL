package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.database.DbCuratedList;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms DbCuratedList to CuratedList .
 */
public class CuratedListFromDbCuratedList extends AnvcePopulatingTransformer<DbCuratedList, CuratedList> {

	@Override
	protected CuratedList createTarget() {
		return new CuratedList();
	}

	@Override
	protected void populateContents(DbCuratedList source, CuratedList target) {
		target.setId(source.getCuratedListId());
		target.setDescription(source.getDescription());
		target.setTitle(source.getTitle());
		target.setListennotes_url(source.getListennotes_url());
		target.setPub_date_ms(source.getPub_date_ms());
		target.setSource_domain(source.getSource_domain());
		target.setSource_url(source.getSource_url());
		target.setPodcasts(new PodcastCustomDataConverter().toCuratedPodcastList(source.getCuaratedPodcastsListAsString()));

	}
}
