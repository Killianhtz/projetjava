package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TypeConsoleNameTest {
	
	
	private int size;
	@SuppressWarnings("unused")
	private String Enum;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
		this.Enum = "V,O,E,S,M,P,B,H";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int expected = 8;
		this.size = TypeConsoleName.values().length;
		assertEquals(expected, size);
	}

}
