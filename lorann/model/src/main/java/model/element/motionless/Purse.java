package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Purse extends MotionlessElement {
	
	/**
	 * Creating sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("B", "purse.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected Purse() throws IOException {
		
		super(Purse.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		
	}
	
}
