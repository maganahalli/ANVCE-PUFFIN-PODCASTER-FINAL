package com.mobile.anvce.puffinpodcaster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.databinding.EpisodeListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.EpisodeListViewHolder;

import java.util.ArrayList;
import java.util.List;

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = EpisodeListAdapter.class.getSimpleName();
	private final Context context;
	private List<Episode> episodeList = new ArrayList<>();

	public EpisodeListAdapter(Context context, List<Episode> list) {
		this.context = context;
		episodeList = list;
	}

	@NonNull
	@Override
	public EpisodeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final EpisodeListItemBinding episodeListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.episode_list_item, parent, false);
		return new EpisodeListViewHolder(context, episodeListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull EpisodeListViewHolder holder, int position) {
		Episode episodeItem = episodeList.get(position);
		holder.episodeListItemBinding.setEpisodeItem(episodeItem);
	}

	@Override
	public int getItemCount() {
		return episodeList != null ? episodeList.size() : 0;
	}
}
