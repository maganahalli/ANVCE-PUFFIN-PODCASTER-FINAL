package com.mobile.anvce.puffinpodcaster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.databinding.BrowseListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.PodcastSearchByCategoryHolder;

import java.util.ArrayList;
import java.util.List;

public class PodcastSearchByCategoryAdapter extends RecyclerView.Adapter<PodcastSearchByCategoryHolder> implements PuffinPodcasterConstants {

	private final static String TAG = PodcastSearchByCategoryAdapter.class.getSimpleName();
	private final Context context;
	private List<PodcastSearchItem> categoryList = new ArrayList<>();

	public PodcastSearchByCategoryAdapter(Context context, List<PodcastSearchItem> list) {
		this.context = context;
		categoryList = list;
	}

	@NonNull
	@Override
	public PodcastSearchByCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		BrowseListItemBinding browseListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.browse_list_item, parent, false);
		return new PodcastSearchByCategoryHolder(context, browseListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull PodcastSearchByCategoryHolder holder, int position) {
		PodcastSearchItem searchItem = categoryList.get(position);
		holder.browseListItemBinding.setSearchItem(searchItem);
	}

	@Override
	public int getItemCount() {
		return categoryList != null ? categoryList.size() : 0;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}
}
