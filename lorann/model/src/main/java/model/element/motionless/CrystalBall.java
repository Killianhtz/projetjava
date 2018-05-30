package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class CrystalBall extends MotionlessElement {
	
	private static final Sprite sprite = new Sprite('E', "crystal_ball.png");

	protected CrystalBall() {
		
		super(CrystalBall.sprite, Permeability.BLOCKING);
		
	}
	
}
