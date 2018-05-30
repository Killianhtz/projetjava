package model.element.motionless;

public class BlockingMotionlessFactory extends MotionlessFactory {
	
	@SuppressWarnings("incomplete-switch")
	public MotionlessElement createElement(TypeMotionless type) {
		
		MotionlessElement motionlesselement = null;
		
		switch(type) {
			
		case GATECLOSE:motionlesselement = new GateClose(GateClose.sprite, GateClose.permeability); 
			break;
		
		case BONE:motionlesselement = new Bone(Bone.sprite, Bone.permeability); 
			break;
		
		case HORIZONTALBONE:motionlesselement = new HorizontalBone(HorizontalBone.sprite, HorizontalBone.permeability);
			break;
		
		case VERTICALBONE:motionlesselement = new VerticalBone(VerticalBone.sprite, VerticalBone.permeability);
			break;
		}
		
		return motionlesselement;
	}
}
