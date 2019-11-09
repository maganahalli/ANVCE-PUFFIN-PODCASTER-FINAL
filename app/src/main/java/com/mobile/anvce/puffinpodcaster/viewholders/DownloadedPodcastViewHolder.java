package com.mobile.anvce.puffinpodcaster.viewholders;

import com.mobile.anvce.puffinpodcaster.databinding.DownloadedPodcastListItemBinding;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DownloadedPodcastViewHolder extends RecyclerView.ViewHolder implements PodcastConstatnts {

	public DownloadedPodcastListItemBinding popularListItemBinding;

	public DownloadedPodcastViewHolder(@NonNull DownloadedPodcastListItemBinding binding) {
		super(binding.getRoot());
		this.popularListItemBinding = binding;
	}

}
