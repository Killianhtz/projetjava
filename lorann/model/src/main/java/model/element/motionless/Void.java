package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Void extends MotionlessElement {
	
	/**
	 * Creating sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("V", "void.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected Void() throws IOException {
		
		super(Void.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
	}
	
}
