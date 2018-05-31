package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class Bone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('O', "bone.png");

	protected Bone() {
		
		super(Bone.SPRITE, Permeability.BLOCKING);
		
	}
	
}
