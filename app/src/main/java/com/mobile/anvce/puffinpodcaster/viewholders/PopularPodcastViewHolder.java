package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.mobile.anvce.puffinpodcaster.databinding.PopularListItemBinding;
import com.mobile.anvce.puffinpodcaster.ui.EpisodesListActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularPodcastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PodcastConstatnts {

	private final static String TAG = PopularPodcastViewHolder.class.getSimpleName();

	private final Context context;
	public PopularListItemBinding popularListItemBinding;

	public PopularPodcastViewHolder(Context context, @NonNull PopularListItemBinding binding) {
		super(binding.getRoot());
		this.context = context;
		this.popularListItemBinding = binding;
		popularListItemBinding.cardLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		onItemClick(view, getAdapterPosition());
	}

	private void onItemClick(View view, int adapterPosition) {
		Log.i(TAG, "You clicked number " + popularListItemBinding.getPodcastItem().toString() + ", which is at cell position " + adapterPosition);
		Intent intent = new Intent(context, EpisodesListActivity.class);
		intent.putExtra(PODCAST_ITEM_KEY, popularListItemBinding.getPodcastItem());
		intent.putExtra(PODCAST_TYPE_KEY, "Popular");
		context.startActivity(intent);
	}
}
