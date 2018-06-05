package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	private void Location(int x2, int i) {
		// TODO Auto-generated method stub
		
	}
	private int X = 15;
	private int Y = 10;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
 
	@Test
	public void testMoveUp() {
		this.Y = Y-1;
		this.Location(X, Y);
		assertEquals(9, Y);
	}
	 
	@Test
	public void testMoveDown() {
		this.Y = Y+1;
		this.Location(X, Y);	
		assertEquals(11, Y);

	}

	@Test
	public void testMoveRight() {
		this.X = X+1;

		this.Location(X+1, Y);	
		assertEquals(16, X);

	}

	@Test
	public void testMoveLeft() {
		this.X = X-1;

		this.Location(X-1, Y);	
		assertEquals(14, X);

	}

}
