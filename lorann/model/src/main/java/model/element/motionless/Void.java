package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Void extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('V', "void.png");

	protected Void() {
		
		super(Void.sprite, Permeability.BLOCKING);
		
	}
	
}
