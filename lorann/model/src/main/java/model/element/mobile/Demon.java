package model.element.mobile;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Demon extends Mobile {
	
	private static Sprite SPRITE = new Sprite("D", "monster_1.png");
	protected Behavior behavior;
	
	public Demon(Behavior behavior) throws IOException {
		
		super(Demon.SPRITE, Permeability.PENETRABLE);
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
