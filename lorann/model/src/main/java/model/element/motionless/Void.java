package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Void extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('V', "void.png");

	protected Void() throws IOException {
		
		super(Void.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}
