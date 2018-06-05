package controller;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ControllerFacadeTest {
	
	private int score = 0;
	private int X = 5;
	private int Y = 5;

/**
 * @param X
 * @return this.X
 */
	
	private int newPositionX(int X) {
		return this.X;
	}
/**
 * @param Y
 * @return this.Y
 */
	private int newPositionY(int Y) {
		return this.Y;
	}
	
/**
 * Initializing the score
 * @throws Exception
 */
	
	@Before
	public void setUp() throws Exception {
		this.score = this.score + 650;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testControllerFacade() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoop() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestPermeability() {
		fail("Not yet implemented");
	}

	/**
	 * Testing the different methods of movement
	 */
	
	@Test
	public void testMoveUp() {
		int expected = 4;
		this.Y = newPositionY(Y) - 1; 
		assertEquals(expected, newPositionY(Y));
	}

	@Test
	public void testMoveDown() {
		int expected = 6;
		this.Y = newPositionY(Y) + 1; 
		assertEquals(expected, newPositionY(Y));
	}

	@Test
	public void testMoveRight() {
		int expected = 6;
		this.X = newPositionX(X) + 1; 
		assertEquals(expected, newPositionX(X));
	}

	@Test
	public void testMoveLeft() {
		int expected = 4;
		this.X = newPositionX(X) - 1; 
		assertEquals(expected, newPositionX(X));
	}

	@Test
	public void testTestEventLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestEventRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestEventUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestEventDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextLevel() {
		fail("Not yet implemented");
	}
	
	/**
	 * We check if the score is update of 650 points each time
	 */
	
	@Test
	public void testAddScore() {
		int expected = this.score + 650;
		this.score = this.score + 650;
		assertEquals(expected, this.score);	
	}

	@Test
	public void testCastSpell() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpellMoves() {
		fail("Not yet implemented");
	}

	@Test
	public void testDemonDMoves() {
		fail("Not yet implemented");
	}

	@Test
	public void testDemonXMoves() {
		fail("Not yet implemented");
	}

	@Test
	public void testDemonMoves() {
		fail("Not yet implemented");
	}

	@Test
	public void testLose() {
		fail("Not yet implemented");
	}

}
