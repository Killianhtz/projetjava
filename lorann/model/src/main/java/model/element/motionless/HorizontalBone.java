package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class HorizontalBone extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.BLOCKING;

	protected HorizontalBone(Sprite sprite, Permeability permeability) {
		
		super(HorizontalBone.sprite, HorizontalBone.permeability);
		
	}
	
}
