package model.element.motionless;

import model.element.Element;
import model.Permeability;
import model.Sprite;

public abstract class MotionlessElement extends Element {

	protected MotionlessElement(final Sprite SPRITE, final Permeability PERMEABILITY) {
		super(SPRITE, PERMEABILITY);
	}
	
}
