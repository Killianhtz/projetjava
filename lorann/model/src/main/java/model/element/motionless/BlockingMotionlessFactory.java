package model.element.motionless;

import java.io.IOException;

public class BlockingMotionlessFactory extends MotionlessFactory {
	
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
