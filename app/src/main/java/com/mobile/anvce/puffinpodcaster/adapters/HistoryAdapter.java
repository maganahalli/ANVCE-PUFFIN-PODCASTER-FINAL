package com.mobile.anvce.puffinpodcaster.adapters;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Episode;
import com.mobile.anvce.puffinpodcaster.databinding.HistoryListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.HistoryViewHolder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> implements PuffinPodcasterConstants {

	private List<Episode> episodeList = new ArrayList<>();

	public HistoryAdapter(List<Episode> list) {
		episodeList = list;
	}

	@NonNull
	@Override
	public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final HistoryListItemBinding historyListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.history_list_item, parent, false);
		return new HistoryViewHolder(historyListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
		Episode episodeItem = episodeList.get(position);
		holder.historyListItemBinding.setEpisodeItem(episodeItem);
	}

	@Override
	public int getItemCount() {
		return episodeList != null ? episodeList.size() : 0;
	}
}
