package com.reatest.toyrobot;

import java.util.Scanner;

import com.reatest.toyrobot.model.Board;
import com.reatest.toyrobot.model.Robot;
import com.reatest.toyrobot.model.RobotException;

public class Main 
{
	private static final String EXIT_STRING = "EXIT";
	
	public static void main(String[] args)
	{
		//Initialize Variables
		Board board = new Board(5,5);
		Robot robot = new Robot();
		Simulator simulator = new Simulator(board, robot);
		boolean exitProgram = false;
		Scanner scanner = new Scanner(System.in);
		
		//Print Menu
		System.out.println("Toy Robot Simulator");
		System.out.println("---------------------");
		System.out.println("Valid Commands Are:");
		System.out.println("PLACE X,Y,NORTH|EAST|SOUTH|WEST");
		System.out.println("MOVE");
		System.out.println("LEFT");
		System.out.println("RIGHT");
		System.out.println("REPORT");
		System.out.println("EXIT");
		System.out.println("---------------------");
		System.out.println("Enter a valid command:");
		
		//Begin Listening to User Input
		while(!exitProgram)
		{
			String inputString = scanner.nextLine();
			if(EXIT_STRING.equals(inputString))
			{
				exitProgram = true;
				scanner.close();
			}
			else
			{
				try
				{
					//Outputs Command result
					System.out.println(simulator.evaluateCommand(inputString));
				}
				catch(RobotException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
