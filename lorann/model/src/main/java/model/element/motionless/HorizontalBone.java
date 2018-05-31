package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class HorizontalBone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("P", "horizontal_bone.png");

	protected HorizontalBone() throws IOException {
		
		super(HorizontalBone.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}