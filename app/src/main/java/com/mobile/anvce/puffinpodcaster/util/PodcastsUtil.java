package com.mobile.anvce.puffinpodcaster.util;

import android.content.Context;

import androidx.annotation.NonNull;

import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.database.PodcastCustomDataConverter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PodcastsUtil {

    private Context context;

    public PodcastsUtil(Context context) {
        this.context = context;
    }

    /**
     * Fetch data from local resource (if network resource isn't available).
     *
     * @param context the application context
     * @return String  JSON string
     */
    public String buildJSONFromLocalResource(@NonNull Context context,@NonNull String filename) {
        String json;
        try {
            InputStream inStream = context.getAssets().open(filename);
            int size = inStream.available();
            byte[] buffer = new byte[size];
            inStream.read(buffer);
            inStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * Fetch data from a local resource.
     *
     * @return List<Podcast> list of podcasts
     */
    public List<Podcast> extractPodcastList(String jsonString) {
        String fileContentString;
        fileContentString = "".equals(jsonString) ? buildJSONFromLocalResource(context,"popularpodcasts.json") : jsonString;
        final List<Podcast> podcasts = new PodcastCustomDataConverter().toPodcastList(fileContentString);
        return podcasts;
    }

    /**
     * Fetch data from a local resource.
     *
     * @return List<CuratedList> list of podcasts
     */
    public List<CuratedList> extractCuratedList(String jsonString) {
        String fileContentString;
        fileContentString = "".equals(jsonString) ? buildJSONFromLocalResource(context,"curatedpodcasts.json") : jsonString;
        final List<CuratedList> curatedLists = new PodcastCustomDataConverter().toCuratedList(fileContentString);
        return curatedLists;
    }

}
