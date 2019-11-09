package com.mobile.anvce.puffinpodcaster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.Podcast;
import com.mobile.anvce.puffinpodcaster.databinding.PopularListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.PopularPodcastViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PopularPodcastAdapter extends RecyclerView.Adapter<PopularPodcastViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = PopularPodcastAdapter.class.getSimpleName();
	private final Context context;
	private List<Podcast> podcastList = new ArrayList<>();

	public PopularPodcastAdapter(Context context, List<Podcast> list) {
		this.context = context;
		podcastList = list;
	}

	@NonNull
	@Override
	public PopularPodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final PopularListItemBinding popularListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.popular_list_item, parent, false);
		return new PopularPodcastViewHolder(context, popularListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull PopularPodcastViewHolder holder, int position) {
		Podcast podcastItem = podcastList.get(position);
		holder.popularListItemBinding.setPodcastItem(podcastItem);
	}

	@Override
	public int getItemCount() {
		return podcastList != null ? podcastList.size() : 0;
	}
}
