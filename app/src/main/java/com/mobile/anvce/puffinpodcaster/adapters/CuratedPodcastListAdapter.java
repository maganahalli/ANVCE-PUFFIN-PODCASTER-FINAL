package com.mobile.anvce.puffinpodcaster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedPodcast;
import com.mobile.anvce.puffinpodcaster.databinding.CuratedPodcastListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.CuratedPodcastListViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CuratedPodcastListAdapter extends RecyclerView.Adapter<CuratedPodcastListViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = CuratedPodcastListAdapter.class.getSimpleName();
	private final Context context;
	private List<CuratedPodcast> curatedPodcastsList = new ArrayList<>();

	public CuratedPodcastListAdapter(Context context, List<CuratedPodcast> list) {
		this.context = context;
		curatedPodcastsList = list;
	}

	@NonNull
	@Override
	public CuratedPodcastListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final CuratedPodcastListItemBinding curatedPodcastBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.curated_podcast_list_item, parent, false);
		return new CuratedPodcastListViewHolder(context, curatedPodcastBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull CuratedPodcastListViewHolder holder, int position) {
		CuratedPodcast podcastItem = curatedPodcastsList.get(position);
		holder.curatedPodcastListItemBinding.setPodcastItem(podcastItem);
	}

	@Override
	public int getItemCount() {
		return curatedPodcastsList != null ? curatedPodcastsList.size() : 0;
	}
}
