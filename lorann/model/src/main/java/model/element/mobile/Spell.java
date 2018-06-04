package model.element.mobile;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Spell extends Mobile {
	
	private Boolean alive = false;
	private Boolean hero = false;
	private Behavior behavior;
	private Direction direction;
	
	private static final Sprite SPRITE = new Sprite("Q", "fireball_1.png");
	
	public Spell() throws IOException {
		super(Spell.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		behaviorType = new SpellBehavior();
	}
	
	public Boolean isAlive() {
		return null;
	}
	
	public Boolean isHero() {
		return null;
	}
}
