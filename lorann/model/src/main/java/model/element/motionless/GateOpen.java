package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class GateOpen extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("M", "gate_open.png");

	protected GateOpen() throws IOException {
		
		super(GateOpen.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		
	}
	
}
