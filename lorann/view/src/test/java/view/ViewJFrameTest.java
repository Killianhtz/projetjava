package view;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewJFrameTest {
	public static int 	width = 640;
	
	public static int 	height = 515;
		
	private Boolean spell = false;
	
	private Point playerMoves = new Point(0,0);
	
	boolean a;
	boolean e;
	boolean z;
	boolean r;
	boolean t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.playerMoves.x = 15;
		this.playerMoves.y = 11;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKeyPressed() {
		if (e) {
	    	  playerMoves.x = 1;
	    	  assertEquals(16, playerMoves.x);
	      }
	      else if (a) {
	    	  playerMoves.x = -1;
	    	  assertEquals(14, playerMoves.x);
	      }
	      else if (z) {
	    	  playerMoves.y = 1;
	    	  assertEquals(12, playerMoves.y);
	      }
	      else if (r) {
	    	  playerMoves.y = -1;
	    	  assertEquals(10, playerMoves.y);
	      }
	      else if (t) {
	    	 this.spell = true;
	    	 assertTrue(spell);
	      }	
		}
	
	@Test
	public void setSpell() {
		this.spell = false;
		assertFalse(spell);
	}

	@Test
	public void testSetDirection() {
		playerMoves.x = 0;
		playerMoves.y = 0;
		assertEquals(0, playerMoves.x);
		assertEquals(0, playerMoves.y);
	}
}
