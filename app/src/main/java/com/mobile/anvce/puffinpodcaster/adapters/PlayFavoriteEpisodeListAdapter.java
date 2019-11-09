package com.mobile.anvce.puffinpodcaster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.databinding.FavoriteEpisodeListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.PlayFavoriteEpisodeListViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PlayFavoriteEpisodeListAdapter extends RecyclerView.Adapter<PlayFavoriteEpisodeListViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = PlayFavoriteEpisodeListAdapter.class.getSimpleName();
	private final Context context;
	private List<Episode> episodeList = new ArrayList<>();

	public PlayFavoriteEpisodeListAdapter(Context context, List<Episode> list) {
		this.context = context;
		episodeList = list;
	}

	@NonNull
	@Override
	public PlayFavoriteEpisodeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final FavoriteEpisodeListItemBinding episodeListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.favorite_episode_list_item, parent, false);
		return new PlayFavoriteEpisodeListViewHolder(context, episodeListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull PlayFavoriteEpisodeListViewHolder holder, int position) {
		Episode episodeItem = episodeList.get(position);
		holder.episodeListItemBinding.setEpisodeItem(episodeItem);
	}

	@Override
	public int getItemCount() {
		return episodeList != null ? episodeList.size() : 0;
	}
}
