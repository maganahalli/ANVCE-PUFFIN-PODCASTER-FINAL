package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.DbListeningHistory;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms DbListeningHistory to Episode.
 */
public class EpisodeFromDbListeningHistory extends AnvcePopulatingTransformer<DbListeningHistory, Episode> {

	@Override
	protected Episode createTarget() {
		return new Episode();
	}

	@Override
	protected void populateContents(DbListeningHistory source, Episode target) {
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
