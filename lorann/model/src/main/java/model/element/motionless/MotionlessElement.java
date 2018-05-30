package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public abstract class MotionlessElement {

	public Sprite sprite;
	public Permeability permeability;

	protected MotionlessElement(Sprite sprite, Permeability permeability) {
		
		this.sprite = sprite;
		this.permeability = permeability;
		
	}
	
}
