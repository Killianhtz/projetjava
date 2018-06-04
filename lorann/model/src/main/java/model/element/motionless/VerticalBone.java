package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class VerticalBone extends MotionlessElement {
	
	/**
	 * Creating sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("H", "vertical_bone.png");
	
	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected VerticalBone() throws IOException {
		
		super(VerticalBone.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}