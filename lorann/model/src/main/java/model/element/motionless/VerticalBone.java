package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class VerticalBone extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.BLOCKING;

	protected VerticalBone(Sprite sprite, Permeability permeability) {
		
		super(VerticalBone.sprite, VerticalBone.permeability);
		
	}
	
}
