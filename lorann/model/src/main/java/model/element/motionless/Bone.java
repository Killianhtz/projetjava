package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Bone extends MotionlessElement {
	
	/**
	 * Creating sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("O", "bone.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected Bone() throws IOException {
		
		super(Bone.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}
