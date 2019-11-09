package com.mobile.anvce.puffinpodcaster.viewholders;

import com.mobile.anvce.puffinpodcaster.databinding.HistoryListItemBinding;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryViewHolder extends RecyclerView.ViewHolder implements PodcastConstatnts {

	public HistoryListItemBinding historyListItemBinding;

	public HistoryViewHolder(@NonNull HistoryListItemBinding binding) {
		super(binding.getRoot());
		this.historyListItemBinding = binding;
	}

}
