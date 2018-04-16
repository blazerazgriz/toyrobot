package com.reatest.toyrobot.model;

/**
 * This interface identifies the basic functionality a Board object would have
 */

public interface BoardInterface 
{
	/**
	 * isPositionValid will return a true or false, basing on the rules of the Board.
	 * @param positionSettings
	 * @return boolean
	 */
	boolean isPositionValid(PositionSettings positionSettings);
}
