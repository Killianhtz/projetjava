package model.element.mobile;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Demon extends Mobile {
	
	private static Sprite[] SPRITE = {new Sprite("D", "monster_1.png"),
									new Sprite("X", "monster_2.png"),
									new Sprite("Z", "monster_3.png"),
									new Sprite("F", "monster_4.png")};
	protected Behavior behavior;
	
	public Demon(Behavior behavior, int a) throws IOException {
		
		super(Demon.SPRITE[a], Permeability.PENETRABLE);
		for (int i = 0; i < SPRITE.length; i++) {
			SPRITE[i].loadImage();
		}
		setBehavior(behavior);
	}
	
	public void setBehavior(Behavior behavior) {
		this.behavior = behavior;
	}
	
	public Direction[] getDirection() {
		return behavior.getBehave();
	}
	
}
