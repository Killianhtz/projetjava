package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class HorizontalBone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('P', "horizontal_bone.png");

	protected HorizontalBone() {
		
		super(HorizontalBone.SPRITE, Permeability.BLOCKING);
		
	}
	
}