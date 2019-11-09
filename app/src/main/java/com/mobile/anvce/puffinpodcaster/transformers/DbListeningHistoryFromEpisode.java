package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.database.DbListeningHistory;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms Episode to DbListeningHistory.
 */
public class DbListeningHistoryFromEpisode extends AnvcePopulatingTransformer<Episode, DbListeningHistory> {

    @Override
    protected DbListeningHistory createTarget() {
        return new DbListeningHistory();
    }

    @Override
    protected void populateContents(Episode source, DbListeningHistory target) {
       target.setAudio(source.getAudio());
       target.setAudioLengthSec(source.getAudioLengthSec());
       target.setDescription(source.getDescription());
       target.setEpisodeId(source.getId());
       target.setExplicitContent(source.getExplicitContent());
       target.setImage(source.getImage());
       target.setListennotesEditUrl(source.getListennotesEditUrl());
       target.setThumbnail(source.getThumbnail());
       target.setTitle(source.getTitle());
       target.setPubDateMs(source.getPubDateMs());
       target.setMaybeAudioInvalid(source.getMaybeAudioInvalid());
    }
}
