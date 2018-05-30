package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class GateOpen extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.PENETRABLE;

	protected GateOpen(Sprite sprite, Permeability permeability) {
		
		super(GateOpen.sprite, GateOpen.permeability);
		
	}
	
}
