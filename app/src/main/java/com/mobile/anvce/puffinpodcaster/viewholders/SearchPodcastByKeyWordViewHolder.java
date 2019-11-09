package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.mobile.anvce.puffinpodcaster.databinding.SearchByKeywordListItemBinding;
import com.mobile.anvce.puffinpodcaster.ui.SearchedKeyWordEpisodesListActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchPodcastByKeyWordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PodcastConstatnts {

	private final static String TAG = SearchPodcastByKeyWordViewHolder.class.getSimpleName();

	private final Context context;
	public SearchByKeywordListItemBinding itemBinding;

	public SearchPodcastByKeyWordViewHolder(Context context, @NonNull SearchByKeywordListItemBinding binding) {
		super(binding.getRoot());
		this.context = context;
		this.itemBinding = binding;
		itemBinding.cardLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		onItemClick(view, getAdapterPosition());
	}

	private void onItemClick(View view, int adapterPosition) {
		Log.i(TAG, "You clicked number " + itemBinding.getSearchedPodcastItem().toString() + ", which is at cell position " + adapterPosition);
		Intent intent = new Intent(context, SearchedKeyWordEpisodesListActivity.class);
		intent.putExtra(SEARCHED_KEY_WORD_ITEM_KEY, itemBinding.getSearchedPodcastItem());
		context.startActivity(intent);

	}
}
