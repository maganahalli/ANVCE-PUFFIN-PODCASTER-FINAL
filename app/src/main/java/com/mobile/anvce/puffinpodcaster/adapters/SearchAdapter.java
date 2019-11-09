package com.mobile.anvce.puffinpodcaster.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.model.PodcastSearchItem;

public class SearchAdapter  extends BaseAdapter {
	private LayoutInflater layoutInflater;
	private List<PodcastSearchItem> listItemStorage;
	public SearchAdapter(Context context, List<PodcastSearchItem> customizedListView) {
		layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		listItemStorage = customizedListView;
	}
	@Override
	public int getCount() {
		return listItemStorage.size();
	}
	@Override
	public Object getItem(int position) {
		return listItemStorage.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder listViewHolder;
		if(convertView == null){
			listViewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.search_list_item, parent, false);
			listViewHolder.dictionaryWord = (TextView)convertView.findViewById(R.id.list_item_search);
			convertView.setTag(listViewHolder);
		}else{
			listViewHolder = (ViewHolder)convertView.getTag();
		}
		listViewHolder.dictionaryWord.setText(listItemStorage.get(position).getKeyword());
		return convertView;
	}
	static class ViewHolder{
		TextView dictionaryWord;
	}
}
