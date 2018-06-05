package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * Corner bone, a blocking motionless element
 */
public class Bone extends MotionlessElement {
	
	/**
	 * Sprite with custom names and image.
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
