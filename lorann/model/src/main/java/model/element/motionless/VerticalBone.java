package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class VerticalBone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('H', "vertical_bone.png");

	protected VerticalBone() {
		
		super(VerticalBone.SPRITE, Permeability.BLOCKING);
		
	}
	
}