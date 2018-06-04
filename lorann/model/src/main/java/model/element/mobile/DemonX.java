package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class DemonX extends Mobile{
	
	private Boolean alive = true;
	
	private static final Sprite SPRITE = new Sprite("X", "monster_2.png");
	
	public DemonX() throws IOException {
		super(DemonX.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		behaviorType = new BehaviorTwo();
	}
	
	public Boolean isAlive() {
		return null;
	}
	
	public Boolean isHero() {
		return null;
	}
	
	public Boolean willCollide(Point position) {
		return null;
	}
	
	public Point getNextPos(Direction direction) {
		return null;
	}
}
