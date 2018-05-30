package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class HorizontalBone extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('P', "horizontal_bone.png");

	protected HorizontalBone() {
		
		super(HorizontalBone.sprite, Permeability.BLOCKING);
		
	}
	
}