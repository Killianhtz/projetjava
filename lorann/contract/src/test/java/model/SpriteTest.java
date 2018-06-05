package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {
	/**
	 *Creation of attributes 
	 */
	private String imageName;
	private String consoleImage;
	private Boolean imageLoaded;
	private String CHARACTER;
	private String IMAGENAME;
	Boolean isImageLoaded;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		/**
		 * Initialization of attributes
		 */
		isImageLoaded = true;
		CHARACTER  = "O";
		IMAGENAME = "bone.png";
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the attributes have the good values
	 */
	
	@Test
	public void testSpriteStringString() {
        this.consoleImage = CHARACTER;
        this.imageName =IMAGENAME;
        assertEquals("O", consoleImage);
        assertEquals("bone.png", imageName);
	}
	
	/**
	 * Test if the boolean have the good state
	 */
	
	@Test
	public void testSetImageLoaded() {
		this.imageLoaded = isImageLoaded;
		assertTrue(imageLoaded);
	}

}
