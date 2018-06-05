package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * A horizontal bone, a blocking motionless element
 */
public class HorizontalBone extends MotionlessElement {

	/**
	 * Sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("P", "horizontal_bone.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected HorizontalBone() throws IOException {
		
		super(HorizontalBone.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}