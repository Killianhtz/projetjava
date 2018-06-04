package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class GateClose extends MotionlessElement {
	
	/**
	 * Creating sprite with custom names and image.
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