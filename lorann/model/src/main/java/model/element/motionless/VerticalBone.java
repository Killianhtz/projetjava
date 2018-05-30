package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class VerticalBone extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('H', "vertical_bone.png");

	protected VerticalBone() {
		
		super(VerticalBone.sprite, Permeability.BLOCKING);
		
	}
	
}