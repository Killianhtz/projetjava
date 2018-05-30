package model.element.motionless;

import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public abstract class MotionlessElement extends Element {

	protected MotionlessElement(final Sprite sprite, final Permeability permeability) {
		super(sprite, permeability);
	}
	
}
