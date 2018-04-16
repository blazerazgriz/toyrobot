package toyrobot;

import org.junit.Assert;
import org.junit.Test;

import com.reatest.toyrobot.model.Board;
import com.reatest.toyrobot.model.Direction;
import com.reatest.toyrobot.model.PositionSettings;

public class BoardTest 
{
	@Test
	public void testIsPositionValid() throws Exception
	{
		Board board = new Board(5,5);
		PositionSettings validPosition = new PositionSettings(2,3,Direction.SOUTH);
		PositionSettings invalidPosition = new PositionSettings(6,5,Direction.NORTH);
		Assert.assertTrue(board.isPositionValid(validPosition));
		Assert.assertFalse(board.isPositionValid(invalidPosition));
	}
}
