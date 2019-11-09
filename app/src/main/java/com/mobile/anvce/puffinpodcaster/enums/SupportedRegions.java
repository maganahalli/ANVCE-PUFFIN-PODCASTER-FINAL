package com.mobile.anvce.puffinpodcaster.enums;

import com.mobile.anvce.puffinpodcaster.patterns.AnvceVisitor;
import com.mobile.anvce.puffinpodcaster.patterns.SupportedRegionsVisitor;

/**
 * Enum models Supported top Podcasts regions of the world.
 */
public enum SupportedRegions {
	USA("us") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitUSA(input);
		}
	}, Australia("at") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitAustralia(input);
		}
	}, Canada("ca") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitCanada(input);
		}
	}, China("cn") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitChina(input);
		}
	}, India("in") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitIndia(input);
		}
	}, Israel("il") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitIsrael(input);
		}
	}, Italy("it") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitItaliy(input);
		}
	}, Ireland("ie") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitIreland(input);
		}
	}, Jamaica("jm") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitJamaica(input);
		}
	}, Japan("jp") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitJapan(input);
		}
	}, Lithuania("lt") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitLithuania(input);
		}
	}, Qatar("qa") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitQatar(input);
		}
	}, Singapore("sg") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitSingapore(input);
		}
	}, South_Africa("za") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitSouthAfrica(input);
		}
	}, Sweden("se") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitSweden(input);
		}
	}, Vietnam("vn") {
		@Override
		public <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input) {
			return visitor.visitVietnam(input);
		}
	};

	private final String regionCode;

	SupportedRegions(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	/**
	 * Invoke the behavior on the supplied visitor that corresponds to the state
	 * of update frequency.
	 *
	 * @param visitor encapsulating behavior that varies by login method
	 * @param input required by visitor
	 * @return output returned by visitor
	 */
	public abstract <I, O> O acceptVisitor(SupportedRegionsVisitor<I, O> visitor, I input);

	/**
	 * Invoke the behavior on the supplied visitor that corresponds to the movie sort criteria and does not require input.
	 *
	 * @param visitor requiring no input
	 * @return output returned by visitor
	 */
	public <O> O acceptVisitor(SupportedRegionsVisitor<Void, O> visitor) {
		return acceptVisitor(visitor, AnvceVisitor.NOTHING);
	}

	public static SupportedRegions fromString(String region) {
		return AnvceEnums.fromString(SupportedRegions.class, region, USA);
	}
}
