package com.mobile.anvce.puffinpodcaster.adapters;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.DownloadedPodcast;
import com.mobile.anvce.puffinpodcaster.databinding.DownloadedPodcastListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.DownloadedPodcastViewHolder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DownloadedPodcastAdapter extends RecyclerView.Adapter<DownloadedPodcastViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = DownloadedPodcastAdapter.class.getSimpleName();
	private List<DownloadedPodcast> podcastList = new ArrayList<>();

	public DownloadedPodcastAdapter(List<DownloadedPodcast> list) {
		podcastList = list;
	}

	@NonNull
	@Override
	public DownloadedPodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final DownloadedPodcastListItemBinding binding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.downloaded_podcast_list_item, parent, false);
		return new DownloadedPodcastViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull DownloadedPodcastViewHolder holder, int position) {
		DownloadedPodcast podcastItem = podcastList.get(position);
		holder.popularListItemBinding.setPodcastItem(podcastItem);
	}

	@Override
	public int getItemCount() {
		return podcastList != null ? podcastList.size() : 0;
	}
}
