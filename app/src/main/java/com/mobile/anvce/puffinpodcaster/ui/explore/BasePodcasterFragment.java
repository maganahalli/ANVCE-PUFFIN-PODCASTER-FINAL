package com.mobile.anvce.puffinpodcaster.ui.explore;

import java.util.Objects;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.mobile.anvce.puffinpodcaster.R;
import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public abstract class BasePodcasterFragment extends Fragment implements PuffinPodcasterConstants {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return getInflatedView(inflater, container);
	}

	protected abstract View getInflatedView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

	/**
	 * Set the SwipeRefreshLayout triggered by a swipe gesture.
	 */
	protected void setSwipeRefreshLayout(@NonNull SwipeRefreshLayout layout, boolean isRefreshing) {
		layout.setColorSchemeColors(getResources().getColor(R.color.black),
				getResources().getColor(R.color.colorAccent),
				getResources().getColor(R.color.colorPrimary));
		layout.setOnRefreshListener(() -> {
			refreshWithAnimation();
			layout.setRefreshing(isRefreshing);
		});
	}

	abstract protected void refreshWithAnimation();

	protected void initializeRecyclerView(RecyclerView recyclerView, int numberofColumns) {
		//Number of Grid layout Columns in each row.
		RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(getContext(), numberofColumns);
		recyclerView.setLayoutManager(recyclerViewLayoutManager);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemViewCacheSize(20);
	}

	protected void refreshWithAnimation(RecyclerView recyclerView) {
		applyRecyclerAnimation(recyclerView);
	}

	protected void applyRecyclerAnimation(RecyclerView recyclerView) {
		Context context = recyclerView.getContext();
		LayoutAnimationController controller =
				AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation);
		recyclerView.setLayoutAnimation(controller);
		Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
		recyclerView.scheduleLayoutAnimation();
	}
}