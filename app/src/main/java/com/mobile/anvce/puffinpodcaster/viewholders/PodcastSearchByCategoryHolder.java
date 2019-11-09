package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.mobile.anvce.puffinpodcaster.databinding.BrowseListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;
import com.mobile.anvce.puffinpodcaster.ui.search.SearchableActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PodcastSearchByCategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PodcastConstatnts {
	private final static String TAG = PodcastSearchByCategoryHolder.class.getSimpleName();
	private final Context context;
	public BrowseListItemBinding browseListItemBinding;

	public PodcastSearchByCategoryHolder(Context context, @NonNull BrowseListItemBinding binding) {
		super(binding.getRoot());
		this.context = context;
		this.browseListItemBinding = binding;
		browseListItemBinding.cardLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		onItemClick(view, getAdapterPosition());
	}

	private void onItemClick(View view, int adapterPosition) {
		Log.i(TAG, "You clicked number " + browseListItemBinding.getSearchItem().toString() + ", which is at cell position " + adapterPosition);
		PodcastSearchItem searchQuery = new PodcastSearchItem(browseListItemBinding.getSearchItem().getKeyword(), browseListItemBinding.getSearchItem().getDescription(),false);
		Intent intent = new Intent(context, SearchableActivity.class);
		intent.putExtra(SEARCH_ITEM_KEY, searchQuery);
		context.startActivity(intent);
	}
}
