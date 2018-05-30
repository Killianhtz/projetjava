package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class CrystalBall extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.PENETRABLE;

	protected CrystalBall(Sprite sprite, Permeability permeability) {
		
		super(CrystalBall.sprite, CrystalBall.permeability);
		
	}
	
}
