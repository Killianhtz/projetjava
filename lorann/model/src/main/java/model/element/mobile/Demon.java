package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Demon extends Mobile{
	
	private Boolean alive = true;
	
	private static final Sprite SPRITE = new Sprite("D", "monster_1.png");
	
	public Demon() throws IOException {
		super(Demon.SPRITE, Permeability.BLOCKING);
		SPRITE.loadImage();
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
