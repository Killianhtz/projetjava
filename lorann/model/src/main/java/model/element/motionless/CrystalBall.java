package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class CrystalBall extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('E', "crystal_ball.png");

	protected CrystalBall() {
		
		super(CrystalBall.SPRITE, Permeability.BLOCKING);
		
	}
	
}
