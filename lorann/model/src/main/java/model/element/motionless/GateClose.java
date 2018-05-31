package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class GateClose extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("S", "gate_closed.png");

	protected GateClose() throws IOException {
		
		super(GateClose.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}