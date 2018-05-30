package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Bone extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.BLOCKING;

	protected Bone(Sprite sprite, Permeability permeability) {
		
		super(Bone.sprite, Bone.permeability);
		
	}
	
}
