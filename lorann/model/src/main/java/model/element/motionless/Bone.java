package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Bone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('O', "bone.png");

	protected Bone() {
		
		super(Bone.SPRITE, Permeability.BLOCKING);
		
	}
	
}
