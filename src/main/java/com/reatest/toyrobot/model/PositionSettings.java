package com.reatest.toyrobot.model;

import com.reatest.toyrobot.model.RobotException;

/**
 * This class represents the Abstract Model of the PositionSettings
 * 
 */

public class PositionSettings 
{
	private int xPosition;
	private int yPosition;
	
	private Direction direction;

	private int xPositionModifier;
	private int yPositionModifier;
	
	public PositionSettings(int x, int y, Direction direction)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.direction = direction;
		this.xPositionModifier = 1;
		this.yPositionModifier = 1;
	}
	
	/**
	 * Constructor with custom Position modifier
	 * For Future Works
	 */
	public PositionSettings(int x, int y, Direction direction, int xModifier,
			int yModifier)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.direction = direction;
		this.xPositionModifier = xModifier;
		this.yPositionModifier = yModifier;
	}
	
	/**
	 * Constructor using another PositionSettings as reference
	 */
	public PositionSettings(PositionSettings posSettings)
	{
		this.xPosition = posSettings.getXPosition();
		this.yPosition = posSettings.getYPosition();
		this.direction = posSettings.getDirection();
		this.xPositionModifier = posSettings.getXModifier();
		this.yPositionModifier = posSettings.getYModifier();
	}
	
	/**
	 * Getters
	 */
	public int getXPosition()	{ return this.xPosition; }
	public int getYPosition()	{ return this.yPosition; }
	public Direction getDirection() { return this.direction; }
	public int getXModifier() { return this.xPositionModifier; }
	public int getYModifier() { return this.yPositionModifier; }
	
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	private void updatePosition(int x, int y)
	{
		this.xPosition = this.xPosition + x;
		this.yPosition = this.yPosition + y;
	}
	
	/**
	 * This Method returns a new PositionSettings object
	 * After determining what the next direction is. 
	 * If direction is undefined, use current.
	 * @return PositionSettings 
	 */
	public PositionSettings getNextPosition() throws RobotException
	{
		if(this.direction==null)
			return this;
		
		PositionSettings newPosition = new PositionSettings(this);
		switch(this.direction)
		{
			case NORTH:
				newPosition.updatePosition(0, yPositionModifier);
				break;
			case EAST:
				newPosition.updatePosition(xPositionModifier, 0);
				break;
			case SOUTH:
				newPosition.updatePosition(0, -yPositionModifier);
				break;
			case WEST:
				newPosition.updatePosition(-xPositionModifier, 0);
				break;
		}
		return newPosition;
	}
}
