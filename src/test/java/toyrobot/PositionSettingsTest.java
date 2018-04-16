package toyrobot;

import org.junit.Test;

import com.reatest.toyrobot.model.Direction;
import com.reatest.toyrobot.model.PositionSettings;
import com.reatest.toyrobot.model.RobotException;

import org.junit.Assert;

public class PositionSettingsTest 
{
	@Test
	public void testGetNextPosition() throws Exception
	{
		PositionSettings position = new PositionSettings(0,0, Direction.NORTH);
		position = position.getNextPosition();
		
		//Positive New Position
		Assert.assertEquals(0, position.getXPosition());
		Assert.assertEquals(1, position.getYPosition());
		Assert.assertEquals(Direction.NORTH, position.getDirection());
		
		position = new PositionSettings(5,5,Direction.NORTH);
		position = position.getNextPosition();
		Assert.assertEquals(5, position.getXPosition());
		Assert.assertEquals(6, position.getYPosition());
		Assert.assertEquals(position.getDirection(), Direction.NORTH);
		
		position.setDirection(position.getDirection().rotateRight());
		position = position.getNextPosition();
		Assert.assertNotEquals(5, position.getXPosition());
		Assert.assertEquals(6, position.getYPosition());
		Assert.assertNotEquals(position.getDirection(), Direction.NORTH);
	}
	
	@Test
	public void testNegativeMove() throws RobotException
	{
		PositionSettings position = new PositionSettings(0,0,null);
		position.getNextPosition();
	}
}