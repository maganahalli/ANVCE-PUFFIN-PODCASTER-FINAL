package com.mobile.anvce.puffinpodcaster.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.SearchResultByKeyWord;
import com.mobile.anvce.puffinpodcaster.databinding.SearchByKeywordListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.SearchPodcastByKeyWordViewHolder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class SearchPodcastByKeyWordAdapter extends RecyclerView.Adapter<SearchPodcastByKeyWordViewHolder> implements PuffinPodcasterConstants {

	private final static String TAG = SearchPodcastByKeyWordAdapter.class.getSimpleName();
	private final Context context;
	private List<SearchResultByKeyWord> podcastList = new ArrayList<>();

	public SearchPodcastByKeyWordAdapter(Context context, List<SearchResultByKeyWord> list) {
		this.context = context;
		podcastList = list;
	}

	@NonNull
	@Override
	public SearchPodcastByKeyWordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final SearchByKeywordListItemBinding itemBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.search_by_keyword_list_item, parent, false);
		return new SearchPodcastByKeyWordViewHolder(context, itemBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull SearchPodcastByKeyWordViewHolder holder, int position) {
		SearchResultByKeyWord podcastItem = podcastList.get(position);
		holder.itemBinding.setSearchedPodcastItem(podcastItem);
	}

	@Override
	public int getItemCount() {
		return podcastList != null ? podcastList.size() : 0;
	}
}
