package com.reatest.toyrobot.model;

import java.util.HashMap;
import java.util.Map;

public enum Direction 
{
	NORTH(0),EAST(1),SOUTH(2),WEST(3);
	private static Map<Integer, Direction> directionMap = 
			new HashMap<Integer, Direction>();
	private int directionIndex;
	
	/**
	 * Keeping a hashmap of enum to directly retrieve enum value based on int
	 */
	static {
		for (Direction directionEnum : Direction.values())
		{
			directionMap.put(directionEnum.directionIndex, directionEnum);
		}
	}
	
	private Direction(int directionValue)
	{
		this.directionIndex = directionValue;
	}
	
	public static Direction valueOf(int directionNum)
	{
		return directionMap.get(directionNum);
	}
	
	/**
	 * Invokes internal rotate method to determine next left rotation
	 * @return Direction
	 */
	public Direction rotateLeft()
	{
		return rotate(-1);
	}
	
	/**
	 * Invokes internal rotate method to determine next right rotation
	 * @return Direction
	 */
	public Direction rotateRight()
	{
		return rotate(1);
	}
	
	/**
	 * Method to rotate direction
	 * Capable of handling rotations that are more than 360 degrees
	 */
	private Direction rotate(int rotationValue)
	{
		int newDirectionIndex = (this.directionIndex + rotationValue) < 0 ?
				directionMap.size() - 1 :
				(this.directionIndex + rotationValue) % directionMap.size();
		return Direction.valueOf(newDirectionIndex);
	}
	
}
