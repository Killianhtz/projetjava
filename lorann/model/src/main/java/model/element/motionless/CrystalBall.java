package model.element.motionless;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class CrystalBall extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("E", "crystal_ball.png");

	protected CrystalBall() throws IOException {
		
		super(CrystalBall.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		
	}
	
}
