package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * A purse, used to get some score points
 */
public class Purse extends MotionlessElement {
	
	/**
	 * Sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("B", "purse.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 */
	protected Purse() throws IOException {
		
		super(Purse.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		
	}
	
}
