package model.element.mobile;

import model.Permeability;
import model.Sprite;

public class Demon extends Mobile {
	
	private static Sprite sprite = new Sprite("D", "monster_1.png");
	protected Behavior behavior;
	
	public Demon(Behavior behavior) {
		
		super(Demon.sprite, Permeability.PENETRABLE);
		setBehavior(behavior);
	}
	
	public void setBehavior(Behavior behavior) {
		this.behavior = behavior;
	}
	
	
}
