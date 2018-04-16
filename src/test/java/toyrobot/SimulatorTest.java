package toyrobot;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.reatest.toyrobot.Simulator;
import com.reatest.toyrobot.model.Board;
import com.reatest.toyrobot.model.Direction;
import com.reatest.toyrobot.model.PositionSettings;
import com.reatest.toyrobot.model.Robot;
import com.reatest.toyrobot.model.RobotException;

public class SimulatorTest 
{
	private final int BOARD_WIDTH = 5;
	private final int BOARD_LENGTH = 5;
	
	@Rule
	public org.junit.rules.ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEvaluateCommand() throws RobotException
	{
		Board board = new Board(BOARD_WIDTH, BOARD_LENGTH);
		Robot robot = new Robot();
		Simulator simulator = new Simulator(board, robot);
		
		simulator.evaluateCommand("PLACE 1,0,EAST");
		Assert.assertEquals("1,0,EAST", simulator.evaluateCommand("REPORT"));
		Assert.assertEquals("true", simulator.evaluateCommand("RIGHT"));
		simulator.evaluateCommand("MOVE");
		simulator.evaluateCommand("RIGHT");
		simulator.evaluateCommand("MOVE");
		
		//Ignores command for going out of board
		Assert.assertEquals("0,0,WEST", simulator.evaluateCommand("REPORT"));
		
		//Full 360 Rotation
		for(int i = 0; i < 4; i++)
		{
			simulator.evaluateCommand("LEFT");
		}
		Assert.assertEquals("0,0,WEST", simulator.evaluateCommand("REPORT"));
		
		//Try going out of bounds again
		simulator.evaluateCommand("RIGHT");
		for(int i = 0; i < 5; i++)
		{
			simulator.evaluateCommand("MOVE");
		}
		Assert.assertEquals("0,5,NORTH", simulator.evaluateCommand("REPORT"));
	}
	
	@Test
	public void testInvalidCommandsException() throws RobotException
	{
		Board board = new Board(BOARD_WIDTH, BOARD_LENGTH);
		Robot robot = new Robot();
		Simulator simulator = new Simulator(board, robot);
		
		thrown.expect(RobotException.class);
		Assert.assertEquals("Invalid command", simulator.evaluateCommand("HELLO"));
		thrown.expect(RobotException.class);
		Assert.assertEquals("Invalid number of arguments for PLACE command",
				simulator.evaluateCommand("PLACE 1,2"));
		thrown.expect(RobotException.class);
		Assert.assertEquals("Invalid Command", simulator.evaluateCommand(
				"PLACE0,0,NORTH"));
		thrown.expect(RobotException.class);
		Assert.assertEquals("Invalid Command", simulator.evaluateCommand( 
				"MOVVEE"));
		thrown.expect(RobotException.class);
		Assert.assertEquals("Invalid Command", simulator.evaluateCommand("MOVE"));
	}
		
	@Test
	public void testPlacingRobot() throws RobotException
	{
		Board board = new Board(BOARD_WIDTH, BOARD_LENGTH);
		Robot robot = new Robot();
		Simulator simulator = new Simulator(board, robot);
		
		Assert.assertTrue(simulator.placeRobot(
				new PositionSettings(0,0,Direction.NORTH)));
		Assert.assertTrue(simulator.placeRobot(
				new PositionSettings(5,5,Direction.WEST)));
		Assert.assertTrue(simulator.placeRobot(
				new PositionSettings(3,2,Direction.EAST)));
		Assert.assertFalse(simulator.placeRobot(
				new PositionSettings(-1,0,Direction.WEST)));
		Assert.assertFalse(simulator.placeRobot(
				new PositionSettings(7,7,Direction.SOUTH)));
	}
	
	@Test
	public void testInvalidPlacingException() throws RobotException
	{
		Board board = new Board(BOARD_WIDTH, BOARD_LENGTH);
		Robot robot = new Robot();
		Simulator simulator = new Simulator(board, robot);
	
		thrown.expect(RobotException.class);
		simulator.placeRobot(null);
		thrown.expect(RobotException.class);
		simulator.placeRobot(new PositionSettings(0,1,null));
	}
}
