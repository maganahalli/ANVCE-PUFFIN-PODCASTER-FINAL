package com.mobile.anvce.puffinpodcaster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.databinding.LaterEpisodeListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.PlayLaterEpisodeListViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PlayLaterEpisodeListAdapter extends RecyclerView.Adapter<PlayLaterEpisodeListViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = PlayLaterEpisodeListAdapter.class.getSimpleName();
	private final Context context;
	private List<Episode> episodeList = new ArrayList<>();

	public PlayLaterEpisodeListAdapter(Context context, List<Episode> list) {
		this.context = context;
		episodeList = list;
	}

	@NonNull
	@Override
	public PlayLaterEpisodeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final LaterEpisodeListItemBinding episodeListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.later_episode_list_item, parent, false);
		return new PlayLaterEpisodeListViewHolder(context, episodeListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull PlayLaterEpisodeListViewHolder holder, int position) {
		Episode episodeItem = episodeList.get(position);
		holder.episodeListItemBinding.setEpisodeItem(episodeItem);
	}

	@Override
	public int getItemCount() {
		return episodeList != null ? episodeList.size() : 0;
	}
}
