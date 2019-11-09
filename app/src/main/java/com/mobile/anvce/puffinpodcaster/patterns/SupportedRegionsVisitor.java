package com.mobile.anvce.puffinpodcaster.patterns;

public interface SupportedRegionsVisitor<I, O> extends AnvceVisitor {

	O visitUSA(I input);

	O visitAustralia(I input);

	O visitCanada(I input);

	O visitChina(I input);

	O visitIndia(I input);

	O visitIsrael(I input);

	O visitItaliy(I input);

	O visitIreland(I input);

	O visitJamaica(I input);

	O visitJapan(I input);

	O visitLithuania(I input);

	O visitQatar(I input);

	O visitSingapore(I input);

	O visitSouthAfrica(I input);

	O visitSweden(I input);

	O visitVietnam(I input);

}
