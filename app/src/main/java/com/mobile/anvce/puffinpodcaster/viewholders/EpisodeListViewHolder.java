package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.mobile.anvce.puffinpodcaster.databinding.EpisodeListItemBinding;
import com.mobile.anvce.puffinpodcaster.ui.details.EpisodeDetailActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodeListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PodcastConstatnts {

	private final static String TAG = EpisodeListViewHolder.class.getSimpleName();
	private final Context context;
	public EpisodeListItemBinding episodeListItemBinding;

	public EpisodeListViewHolder(Context context, @NonNull EpisodeListItemBinding binding) {
		super(binding.getRoot());
		this.context = context;
		this.episodeListItemBinding = binding;
		episodeListItemBinding.episodeItemLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		onItemClick(view, getAdapterPosition());
	}

	private void onItemClick(View view, int adapterPosition) {
		Log.i(TAG, "You clicked number " + episodeListItemBinding.getEpisodeItem().toString() + ", which is at cell position " + adapterPosition);
		Intent intent = new Intent(context, EpisodeDetailActivity.class);
		intent.putExtra(EPISODE_ITEM_KEY, episodeListItemBinding.getEpisodeItem());
		context.startActivity(intent);

	}
}
