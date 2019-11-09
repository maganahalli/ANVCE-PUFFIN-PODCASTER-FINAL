package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms DbEpisode to Episode.
 */
public class EpisodeFromDbEpisode extends AnvcePopulatingTransformer<DbEpisode, Episode> {

	@Override
	protected Episode createTarget() {
		return new Episode();
	}

	@Override
	protected void populateContents(DbEpisode source, Episode target) {
		target.setAudio(source.getAudio());
		target.setAudioLengthSec(source.getAudioLengthSec());
		target.setDescription(source.getDescription());
		target.setId(source.getEpisodeId());
		target.setExplicitContent(source.getExplicitContent());
		target.setImage(source.getImage());
		target.setListennotesEditUrl(source.getListennotesEditUrl());
		target.setThumbnail(source.getThumbnail());
		target.setTitle(source.getTitle());
		target.setPubDateMs(source.getPubDateMs());
		target.setMaybeAudioInvalid(source.getMaybeAudioInvalid());
	}
}
