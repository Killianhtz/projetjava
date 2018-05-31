package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class VerticalBone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("H", "vertical_bone.png");

	protected VerticalBone() throws IOException {
		
		super(VerticalBone.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}