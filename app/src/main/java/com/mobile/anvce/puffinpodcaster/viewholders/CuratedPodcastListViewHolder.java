package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.databinding.CuratedPodcastListItemBinding;
import com.mobile.anvce.puffinpodcaster.ui.CuratedEpisodesListActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

public class CuratedPodcastListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PodcastConstatnts {
	private final static String TAG = CuratedPodcastListViewHolder.class.getSimpleName();
	private final Context context;
	public CuratedPodcastListItemBinding curatedPodcastListItemBinding;

    public CuratedPodcastListViewHolder(Context context, @NonNull CuratedPodcastListItemBinding binding) {
        super(binding.getRoot());
		this.context = context;
        this.curatedPodcastListItemBinding = binding;
		curatedPodcastListItemBinding.curatePodcastLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		onItemClick(view, getAdapterPosition());
	}

	private void onItemClick(View view, int adapterPosition) {
        Log.i(TAG, "You clicked number " + curatedPodcastListItemBinding.getPodcastItem().toString() + ", which is at cell position " + adapterPosition);
		Intent intent = new Intent(context, CuratedEpisodesListActivity.class);
		intent.putExtra(CURATED_PODCAST_ITEM_KEY, curatedPodcastListItemBinding.getPodcastItem());
		intent.putExtra(PODCAST_TYPE_KEY,"Curated");
		context.startActivity(intent);
	}
}
