package model.element.motionless;

public class PenetrableMotionlessFactory extends MotionlessFactory {
	
	@SuppressWarnings("incomplete-switch")
	public MotionlessElement createElement(TypeMotionless type) {
		
		MotionlessElement motionlesselement = null;
		
		switch(type) {
			
		case PURSE:motionlesselement = new Purse( Purse.sprite,  Purse.permeability); 
			break;
		
		case GATEOPEN:motionlesselement = new GateOpen(GateOpen.sprite, GateOpen.permeability); 
			break;
		
		case CRYSTALBALL:motionlesselement = new CrystalBall(CrystalBall.sprite, CrystalBall.permeability);
			break;
		
		}
		
		return motionlesselement;
	}
}
