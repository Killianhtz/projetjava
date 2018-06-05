package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * A crystal ball, or the key to open the door
 */
public class CrystalBall extends MotionlessElement {
	
	/**
	 * Sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("E", "crystal_ball.png");

	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected CrystalBall() throws IOException {
		
		super(CrystalBall.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		
	}
	
}
