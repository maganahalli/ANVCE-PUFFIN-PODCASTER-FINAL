package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.databinding.LaterEpisodeListItemBinding;
import com.mobile.anvce.puffinpodcaster.repository.PlayLaterEpisodeRepository;
import com.mobile.anvce.puffinpodcaster.ui.details.EpisodeDetailActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

public class PlayLaterEpisodeListViewHolder extends RecyclerView.ViewHolder implements PodcastConstatnts {

	private final static String TAG = PlayLaterEpisodeListViewHolder.class.getSimpleName();
	private final Context context;
	public LaterEpisodeListItemBinding episodeListItemBinding;

	public PlayLaterEpisodeListViewHolder(Context context, @NonNull LaterEpisodeListItemBinding binding) {
		super(binding.getRoot());
		this.context = context;
		this.episodeListItemBinding = binding;
		episodeListItemBinding.playImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onItemClick(view, getAdapterPosition());
			}
		});

		episodeListItemBinding.deleteImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onDeleteImageClick(v,getAdapterPosition());
			}
		});
	}

	private void onDeleteImageClick(View v, int adapterPosition) {
		Log.i(TAG, "You clicked delete image for  " + episodeListItemBinding.getEpisodeItem().toString() + ", which is at cell position " + adapterPosition);
		PlayLaterEpisodeRepository repository = new PlayLaterEpisodeRepository(context.getApplicationContext());
		repository.deleteEpisodeFromPlayLaterList(episodeListItemBinding.getEpisodeItem());
	}


	private void onItemClick(View view, int adapterPosition) {
		Log.i(TAG, "You clicked number " + episodeListItemBinding.getEpisodeItem().toString() + ", which is at cell position " + adapterPosition);
		Intent intent = new Intent(context, EpisodeDetailActivity.class);
		intent.putExtra(EPISODE_ITEM_KEY, episodeListItemBinding.getEpisodeItem());
		context.startActivity(intent);

	}
}
