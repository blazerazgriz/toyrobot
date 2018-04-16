package com.reatest.toyrobot.model;

/**
 * This class is an Abstract class of the Play Board
 */

public class Board implements BoardInterface
{
	//Board Variables
	private int boardLength;
	private int boardWidth;
	
	public Board (int x, int y)
	{
		this.boardWidth = x;
		this.boardLength = y;
	}
	
	/**
	 * Checks if PositionSettings value satisfy board rule
	 * 
	 * @return false if exceeds board limit
	 */
	public boolean isPositionValid(PositionSettings positionSettings) 
	{
		int xCheck = positionSettings.getXPosition();
		int yCheck = positionSettings.getYPosition();
		
		return !(xCheck > this.boardWidth || xCheck < 0 ||
				yCheck > this.boardLength || yCheck < 0 );
	}
}
