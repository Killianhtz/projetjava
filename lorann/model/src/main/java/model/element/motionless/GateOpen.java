package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class GateOpen extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('M', "gate_open.png");

	protected GateOpen() {
		
		super(GateOpen.sprite, Permeability.BLOCKING);
		
	}
	
}
