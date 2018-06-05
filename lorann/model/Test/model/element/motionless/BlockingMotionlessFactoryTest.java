package model.element.motionless;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlockingMotionlessFactoryTest {
	private static final int GATECLOSE = 0;
	private static final int BONE = 1;
	private static final int HORIZONTALBONE = 2;
	private static final int VERTICALBONE = 3;
	int type;
	MotionlessElement motionlesselement;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		motionlesselement = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateElement() {
		try {
			
			switch(type) {
				
			case GATECLOSE: motionlesselement = new GateClose(); 
				break;
			
			case BONE: motionlesselement = new Bone(); 
				break;
			
			case HORIZONTALBONE: motionlesselement = new HorizontalBone();
				break;
			
			case VERTICALBONE: motionlesselement = new VerticalBone();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(motionlesselement);
	}

}
