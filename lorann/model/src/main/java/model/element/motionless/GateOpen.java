package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;
/**
 * An opened gate, penetrable motionless element
 */
public class GateOpen extends MotionlessElement {
	
	/**
	 * Sprite with custom names and image.
	 */
	private static final Sprite SPRITE = new Sprite("M", "gate_open.png");

	/**
	 * Creating object with a loaded sprite and a permeability.
	 * @throws IOException
	 */
	protected GateOpen() throws IOException {
		
		super(GateOpen.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		
	}
	
}
