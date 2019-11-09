package com.mobile.anvce.puffinpodcaster.enums;

import com.mobile.anvce.puffinpodcaster.patterns.AnvceVisitor;

public enum PodcastUpdateFrequency {
	EIGHT_HOUR{
		@Override
		public <I, O> O acceptVisitor(PodcastUpdateFrequencyVisitor<I, O> visitor, I input) {
			return visitor.visitEightHour(input);
		}
	}
	,EVERY_DAY{
		@Override
		public <I, O> O acceptVisitor(PodcastUpdateFrequencyVisitor<I, O> visitor, I input) {
			return visitor.visitEveryDay(input);
		}
	}

	,WEEKLY{
		@Override
		public <I, O> O acceptVisitor(PodcastUpdateFrequencyVisitor<I, O> visitor, I input) {
			return visitor.visitWeekly(input);
		}
	}

	;

	public interface PodcastUpdateFrequencyVisitor<I, O> extends AnvceVisitor {

		O visitEightHour(I input);

		O visitEveryDay(I input);

		O visitWeekly(I input);

	}

	public static PodcastUpdateFrequency fromString(String frequency) {
		return AnvceEnums.fromString(PodcastUpdateFrequency.class, frequency, EVERY_DAY);
	}

	/**
	 * Invoke the behavior on the supplied visitor that corresponds to the state
	 * of update frequency.
	 *
	 * @param visitor encapsulating behavior that varies by login method
	 * @param input required by visitor
	 * @return output returned by visitor
	 */
	public abstract <I, O> O acceptVisitor(PodcastUpdateFrequencyVisitor<I, O> visitor, I input);

	/**
	 * Invoke the behavior on the supplied visitor that corresponds to the movie sort criteria and does not require input.
	 *
	 * @param visitor requiring no input
	 * @return output returned by visitor
	 */
	public <O> O acceptVisitor(PodcastUpdateFrequencyVisitor<Void, O> visitor) {
		return acceptVisitor(visitor, AnvceVisitor.NOTHING);
	}
}
