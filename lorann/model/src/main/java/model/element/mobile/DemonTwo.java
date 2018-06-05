package model.element.mobile;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class DemonTwo extends Mobile {
	
	private static Sprite SPRITE = new Sprite("X","monster_2.png");
	protected Behavior behavior;
	
	public DemonTwo(Behavior behavior) throws IOException {
		
		super(DemonTwo.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		setBehavior(behavior);
	}
	
	public void setBehavior(Behavior behavior) {
		this.behavior = behavior;
	}
	
	public Direction[] getDirection() {
		return behavior.getBehave();
	}
	
}
