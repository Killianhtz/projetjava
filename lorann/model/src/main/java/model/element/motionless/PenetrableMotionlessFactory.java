package model.element.motionless;

import java.io.IOException;
/* 
 * Subclass of the abstract superclass MotionlessFactory, in charge of the creation of penetrable motionless Elements.
 */
public class PenetrableMotionlessFactory extends MotionlessFactory {
	
	/* 
	 * Method used to create penetrable motionless elements.
	 */
	@SuppressWarnings("incomplete-switch")
	public MotionlessElement createElement(TypeMotionless type) throws IOException {
		
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
