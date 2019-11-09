package com.mobile.anvce.puffinpodcaster.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.api.model.CuratedList;
import com.mobile.anvce.puffinpodcaster.databinding.CuratedListItemBinding;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;
import com.mobile.anvce.puffinpodcaster.viewholders.CuratedListViewHolder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CuratedListAdapter extends RecyclerView.Adapter<CuratedListViewHolder> implements PuffinPodcasterConstants {

	private final Context context;
	private List<CuratedList> curatedtList = new ArrayList<>();

	public CuratedListAdapter(Context context, List<CuratedList> list) {
		this.context = context;
		curatedtList = list;
	}

	@NonNull
	@Override
	public CuratedListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		final CuratedListItemBinding cuartedListBinding =
				DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
						R.layout.curated_list_item, parent, false);
		return new CuratedListViewHolder(context, cuartedListBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull CuratedListViewHolder holder, int position) {
		CuratedList curatedItem = curatedtList.get(position);
		holder.curatedListItemBinding.setCuratedListItem(curatedItem);
	}

	@Override
	public int getItemCount() {
		return curatedtList != null ? curatedtList.size() : 0;
	}
}
