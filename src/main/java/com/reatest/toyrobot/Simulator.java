package com.reatest.toyrobot;

import com.reatest.toyrobot.model.Board;
import com.reatest.toyrobot.model.Command;
import com.reatest.toyrobot.model.Direction;
import com.reatest.toyrobot.model.PositionSettings;
import com.reatest.toyrobot.model.Robot;
import com.reatest.toyrobot.model.RobotException;

public class Simulator 
{
	private Board simulatorBoard;
	private Robot robot;
	
	public Simulator(Board board, Robot robot)
	{
		this.simulatorBoard = board;
		this.robot = robot;
	}
	
	/*
	 * placeRobot method that takes in a PositionSettings object
	 * Method validates the input before calling the place robot method
	 * The valid acceptable format is [PLACE X,Y,F] 
	 * Any missing arguments will throw a RobotException
	 */
	public boolean placeRobot(PositionSettings positionSettings) 
			throws RobotException
	{
		if(positionSettings == null)
			throw new RobotException("Invalid Position");
		
		if(this.simulatorBoard == null)
			throw new RobotException("No board available");
		
		if(positionSettings.getDirection() == null)
			throw new RobotException("No Direction Avaialble");
		
		if(simulatorBoard.isPositionValid(positionSettings))
		{
			robot.setPosition(positionSettings);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Report Method for Reporting robot in the following format
	//X,Y,DIRECTION
	private String report()
	{
		if(robot.getPosition() == null)
			return null;
	
		return robot.getPosition().getXPosition() + "," +
			robot.getPosition().getYPosition() + "," +
			robot.getPosition().getDirection().toString();
	}
	
	//Evaluate Commands
	public String evaluateCommand(String inputString) throws RobotException
	{
		Command command;
		Direction direction = null;
		String result = null;
		String[] args = inputString.split(" ");
		int x = 0;
		int y = 0;
		
		//Convert String input to enum Command
		try
		{
			command = Command.valueOf(args[0]);
		}
		catch(IllegalArgumentException e)
		{
			throw new RobotException ("Invalid Command");
		}
		
		//Validate PLACE Command if Command is PLACE
		if(command == Command.PLACE)
		{
			String[] posVar = args[1].split(",");
			if(posVar.length == 3)
			{
				try
				{
					x = Integer.parseInt(posVar[0]);
					y = Integer.parseInt(posVar[1]);
					direction = Direction.valueOf(posVar[2]);
				}
				catch (Exception e)
				{
					throw new RobotException ("Invalid PLACE Parameters");
				}
			}
			else
			{
				throw new RobotException ("Invalid number of "
						+ "arguments for PLACE command");
		
			}
		}
		
		//Determine Which Command to execute base on args
		switch(command)
		{
		case PLACE:
			result = String.valueOf(placeRobot(
					new PositionSettings(x, y, direction)));
			break;
		case MOVE:
			PositionSettings postPosition = robot.getPosition();
			if(postPosition != null && simulatorBoard.isPositionValid(
					postPosition.getNextPosition()))
			{
				result = String.valueOf(robot.move(
						postPosition.getNextPosition()));				
			}
			break;
		case LEFT:
			result = String.valueOf(this.robot.rotateLeft());
			break;
		case RIGHT:
			result = String.valueOf(this.robot.rotateRight());
			break;
		case REPORT:
			result = report();
			break;
		default:
			throw new RobotException("Invalid Command");
		}
		return result;
	}
}
