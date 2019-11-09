package com.mobile.anvce.puffinpodcaster.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.mobile.anvce.puffinpodcaster.model.PuffinPodcasterConstants;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * This is used for photo image in the common podcaster sub header view.
 */
public class AnvceAspectRatioImageView extends AppCompatImageView implements PuffinPodcasterConstants {

	public AnvceAspectRatioImageView(Context context) {
		super(context);
	}

	public AnvceAspectRatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AnvceAspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int threeTwoHeight = MeasureSpec.getSize(widthMeasureSpec) * TWO / THREE;
		int threeTwoHeightSpec =
				MeasureSpec.makeMeasureSpec(threeTwoHeight, MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, threeTwoHeightSpec);
	}
}
