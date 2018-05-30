package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement {
	
	public static Sprite sprite;
	public static Permeability permeability = Permeability.PENETRABLE;

	protected Purse(Sprite sprite, Permeability permeability) {
		
		super(Purse.sprite, Purse.permeability);
		
	}
	
}
