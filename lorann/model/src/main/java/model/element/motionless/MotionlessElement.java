package model.element.motionless;

import model.element.Element;
import model.Permeability;
import model.Sprite;

/**
 * Abstract superclass of all motionless elements.
 */
public abstract class MotionlessElement extends Element {
	/**
	 * Constructor of the abstract superclass MotionlessElement
	 */
	protected MotionlessElement(final Sprite SPRITE, final Permeability PERMEABILITY) {
		super(SPRITE, PERMEABILITY);
	}
	
}
