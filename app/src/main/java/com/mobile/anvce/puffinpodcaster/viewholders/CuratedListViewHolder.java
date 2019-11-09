package com.mobile.anvce.puffinpodcaster.viewholders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.anvce.puffinpodcaster.databinding.CuratedListItemBinding;
import com.mobile.anvce.puffinpodcaster.ui.CuratedPodcastListActivity;
import com.mobile.anvce.puffinpodcaster.util.PodcastConstatnts;

public class CuratedListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PodcastConstatnts {
    private final static String TAG = CuratedListViewHolder.class.getSimpleName();
    private final Context context;
    public CuratedListItemBinding curatedListItemBinding;

    public CuratedListViewHolder(Context context, @NonNull CuratedListItemBinding binding) {
        super(binding.getRoot());
        this.context = context;
        this.curatedListItemBinding = binding;
        curatedListItemBinding.curatedItemLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemClick(view, getAdapterPosition());
    }

    private void onItemClick(View view, int adapterPosition) {
        Log.i(TAG, "You clicked number " + curatedListItemBinding.getCuratedListItem().toString() + ", which is at cell position " + adapterPosition);
        Intent intent = new Intent(context, CuratedPodcastListActivity.class);
        intent.putExtra(CURATED_LIST_ITEM_KEY, curatedListItemBinding.getCuratedListItem());
        intent.putExtra(PODCAST_TYPE_KEY, "Recommended");
        context.startActivity(intent);

    }
}
