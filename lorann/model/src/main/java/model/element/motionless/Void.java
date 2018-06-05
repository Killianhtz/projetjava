package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * Void. Litteraly.
 */
public class Void extends MotionlessElement {
	
	/**
	 * Sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("V", "void.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 */
	protected Void() throws IOException {
		
		super(Void.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
	}
	
}
