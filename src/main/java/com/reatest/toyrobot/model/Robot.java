package com.reatest.toyrobot.model;

public class Robot 
{
	private PositionSettings positionSettings;
	
	public Robot()
	{
		
	}
	
	public Robot(PositionSettings positionSettings)
	{
		this.positionSettings = positionSettings;
	}
	
	/**
	 * Rotates Left if conditions are met
	 * @return true if rotation was successful
	 */
	public boolean rotateLeft()
	{
		if (positionSettings == null || this.positionSettings.getDirection() == null)
			return false;
		
		this.positionSettings.setDirection(this.positionSettings.getDirection().rotateLeft());
		return true;		
	}
	
	/**
	 * Rotates Right if conditions are met
	 * @return true if rotation was successful
	 */
	public boolean rotateRight()
	{
		if (positionSettings == null || this.positionSettings.getDirection() == null)
			return false;
		
		this.positionSettings.setDirection(this.positionSettings.getDirection().rotateRight());
		return true;		
	}
	
	public PositionSettings getPosition()
	{
		return this.positionSettings;
	}
	
	/**
	 * Sets the Robot to the new position
	 * Based on PositionSetting's getNextPosition method
	 * @param newPosition
	 * @return true if move was successful
	 */
	public boolean move(PositionSettings newPosition)
	{
		if(newPosition == null)
			return false;
		
		this.positionSettings = newPosition;
		return true;
	}
	
	public void setPosition(PositionSettings positionSettings)
	{
		if(positionSettings != null)
			this.positionSettings = positionSettings;
	}	
}
