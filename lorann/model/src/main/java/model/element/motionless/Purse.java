package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Purse extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('B', "purse.png");

	protected Purse() throws IOException {
		
		super(Purse.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}
