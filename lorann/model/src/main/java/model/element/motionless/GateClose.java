package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * A closed gate, blocking motionless element.
 */
public class GateClose extends MotionlessElement {
	
	/**
	 * Sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("S", "gate_closed.png");

	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected GateClose() throws IOException {
		
		super(GateClose.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}