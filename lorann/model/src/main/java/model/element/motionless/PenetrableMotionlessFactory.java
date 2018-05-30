package model.element.motionless;

public class PenetrableMotionlessFactory extends MotionlessFactory {
	
	@SuppressWarnings("incomplete-switch")
	public MotionlessElement createElement(TypeMotionless type) {
		
		MotionlessElement motionlesselement = null;
		
		switch(type) {
			
		case PURSE:motionlesselement = new Purse(); 
			break;
		
		case GATEOPEN:motionlesselement = new GateOpen(); 
			break;
		
		case CRYSTALBALL:motionlesselement = new CrystalBall();
			break;
		
		case VOID:motionlesselement = new Void();
		}
		
		return motionlesselement;
	}
}
