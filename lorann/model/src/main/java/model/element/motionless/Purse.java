package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class Purse extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('B', "purse.png");

	protected Purse() {
		
		super(Purse.SPRITE, Permeability.BLOCKING);
		
	}
	
}
