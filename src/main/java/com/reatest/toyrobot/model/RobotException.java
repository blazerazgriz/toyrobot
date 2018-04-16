package com.reatest.toyrobot.model;

/**
 * Custom Excpetion Class for handling Error Scenarios within the Simulator
 */

public class RobotException extends Exception
{
	private static final long serialVersionUID = -8812047135317937245L;
	public RobotException(String exceptionMessage)
	{
		super(exceptionMessage);
	}
}
