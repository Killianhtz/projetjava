package model.element.motionless;

import java.io.IOException;

/** 
 * Subclass of the abstract superclass MotionlessFactory, in charge of the creation of blocking motionless Elements.
 */
public class BlockingMotionlessFactory extends MotionlessFactory {
	
	/* 
	 * Method used to create blocking motionless elements.
	 */
	@SuppressWarnings("incomplete-switch")
	public MotionlessElement createElement(TypeMotionless type) throws IOException {
		
		MotionlessElement motionlesselement = null;
		
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
		
		return motionlesselement;
	}
}
