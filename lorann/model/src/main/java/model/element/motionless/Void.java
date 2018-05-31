package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class Void extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('V', "void.png");

	protected Void() {
		
		super(Void.SPRITE, Permeability.BLOCKING);
		
	}
	
}
