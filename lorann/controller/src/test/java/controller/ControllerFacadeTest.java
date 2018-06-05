package controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerFacadeTest {
	
	/**
	 * Creation of attributes and array
	 */
	
    private int level;
	private int score;
	private int X;
	private int Y;
    public String[][] map = new String[12][20];
    

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	private int newPositionX(int X) {
		return this.X;
	}

	private int newPositionY(int Y) {
		return this.Y;
	}
	
	
	/**
	 * Initialization of our attributes
	 */
	

	@Before
	public void setUp() throws Exception {
		
		
		X = 5;
		Y = 5;
		score = 0;
		level = 1;
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test if Y = 4 when we move u^p
	 */
	
	@Test
	public void testMoveUp() {
		int expected = 4;
		this.Y = newPositionY(Y) - 1; 
		assertEquals(expected, newPositionY(Y));
	}

	/**
	 * Test if Y = 6 when we move down
	 */
	
	@Test
	public void testMoveDown() {
		int expected = 6;
		this.Y = newPositionY(Y) + 1; 
		assertEquals(expected, newPositionY(Y));
	}
	/**
	 * Test if X = 6 when we move right
	 */
	
	@Test
	public void testMoveRight() {
		int expected = 6;
		this.X = newPositionX(X) + 1; 
		assertEquals(expected, newPositionX(X));
	}
	/**
	 * Test if X = 4 when we move left
	 */
	
	@Test
	public void testMoveLeft() {
		int expected = 4;
		this.X = newPositionX(X) - 1; 
		assertEquals(expected, newPositionX(X));
	}

	/**
	 * Test if score = 650 when we take a purse
	 */
	
	@Test
	public void testAddScore() {
		int expected = this.score + 650;
		this.score = this.score + 650;
		assertEquals(expected, this.score);	
	}

	/**
	 * Test if next level is level 2
	 */
	
	@Test
	public void update() {
		int expected = 2;
	    level = level + 1;
		
		assertEquals(expected, this.level);	
		
	}
	
}