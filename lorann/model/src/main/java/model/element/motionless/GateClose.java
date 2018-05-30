package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class GateClose extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('S', "gate_closed.png");

	protected GateClose() {
		
		super(GateClose.sprite, Permeability.BLOCKING);
		
	}
	
}