package com.mobile.anvce.puffinpodcaster.enumerators;
/**
 * API for determining if a match is found with the provided element. Each
 * implementation is responsible for specifying how a match is determined.
 *
 * @author Venky Maganahalli
 * @param <E> type of element, for example: InputFieldDefinition
 */
public interface AnvceMatcher<E, I extends Number> {

	/**
	 * Determines if a match is found.
	 *
	 * @param element the current item from the collection, could be null. Each
	 *            implementation should handle this possibility.
	 * @return true/false if a match is found
	 */
	boolean isMatch(E element);

}
