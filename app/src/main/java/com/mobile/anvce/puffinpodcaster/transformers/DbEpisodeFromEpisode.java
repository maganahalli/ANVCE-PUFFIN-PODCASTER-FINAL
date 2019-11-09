package com.mobile.anvce.puffinpodcaster.transformers;

import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.DbEpisode;
import com.mobile.anvce.puffinpodcaster.database.DbPodcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;
import com.mobile.anvce.puffinpodcaster.populators.AnvcePopulatingTransformer;

/**
 * Transforms Episode to DbEpisode.
 */
public class DbEpisodeFromEpisode extends AnvcePopulatingTransformer<Episode, DbEpisode> {

    @Override
    protected DbEpisode createTarget() {
        return new DbEpisode();
    }

    @Override
    protected void populateContents(Episode source, DbEpisode target) {
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
