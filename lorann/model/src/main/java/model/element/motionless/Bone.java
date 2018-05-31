package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Bone extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('O', "bone.png");

	protected Bone() throws IOException {
		
		super(Bone.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
		
	}
	
}
