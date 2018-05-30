package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('B', "purse.png");

	protected Purse() {
		
		super(Purse.sprite, Permeability.BLOCKING);
		
	}
	
}
