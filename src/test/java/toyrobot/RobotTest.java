package toyrobot;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.reatest.toyrobot.model.Direction;
import com.reatest.toyrobot.model.PositionSettings;
import com.reatest.toyrobot.model.Robot;
import com.reatest.toyrobot.model.RobotException;

public class RobotTest {

	@Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

	@Test
	public void testRobotConstruction() throws RobotException 
	{
		Robot robot = new Robot(new PositionSettings(0,0,Direction.NORTH));
		
		//Test Robot Position
		Assert.assertEquals(0, robot.getPosition().getXPosition());
		Assert.assertEquals(0, robot.getPosition().getYPosition());
		Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
		
		robot.move(robot.getPosition().getNextPosition());
	}
	
	@Test
	public void testRobotMove() throws RobotException
	{
		Robot robot = new Robot(new PositionSettings(0,0,Direction.NORTH));
		robot.move(robot.getPosition().getNextPosition());
		
		Assert.assertEquals(0, robot.getPosition().getXPosition());
		Assert.assertEquals(1, robot.getPosition().getYPosition());
		Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
	}
	
	@Test
	public void testRobotRotation()
	{
		Robot robot = new Robot(new PositionSettings(0,0,Direction.NORTH));
		
		//Turn Right
		robot.rotateRight();
		Assert.assertEquals(Direction.EAST, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(Direction.WEST, robot.getPosition().getDirection());
		robot.rotateRight();
		Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
		
		//Turn Left
		robot.rotateLeft();
		Assert.assertEquals(Direction.WEST, robot.getPosition().getDirection());
		robot.rotateLeft();
		Assert.assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
		robot.rotateLeft();
		Assert.assertEquals(Direction.EAST, robot.getPosition().getDirection());
		robot.rotateLeft();
		Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());
	}
	
	@Test
	public void testRobotRotateAndMove() throws RobotException
	{
		Robot robot = new Robot(new PositionSettings(0,0,Direction.NORTH));
		
		robot.rotateRight();
		robot.move(robot.getPosition().getNextPosition());
		Assert.assertEquals(1, robot.getPosition().getXPosition());
		Assert.assertEquals(0, robot.getPosition().getYPosition());
		Assert.assertEquals(Direction.EAST, robot.getPosition().getDirection());
		
		robot.setPosition(new PositionSettings(2,3,Direction.WEST));
		robot.rotateLeft();
		robot.move(robot.getPosition().getNextPosition());
		Assert.assertEquals(2, robot.getPosition().getXPosition());
		Assert.assertEquals(2, robot.getPosition().getYPosition());
		Assert.assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
	}
}
