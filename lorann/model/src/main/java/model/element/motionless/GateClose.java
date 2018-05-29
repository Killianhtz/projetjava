package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class GateClose extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.BLOCKING;
	
	public GateClose(Sprite sprite, Permeability permeability) {
		super(GateClose.sprite, GateClose.permeability);
	}
}
