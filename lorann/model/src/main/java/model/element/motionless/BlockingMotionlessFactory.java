package model.element.motionless;

public class BlockingMotionlessFactory extends MotionlessFactory {
	
	@SuppressWarnings("incomplete-switch")
	public MotionlessElement createElement(TypeMotionless type) {
		
		MotionlessElement motionlesselement = null;
		
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
		
		return motionlesselement;
	}
}
