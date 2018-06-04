package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class DemonD extends Mobile{
	
	private Boolean alive = true;
	
	private static final Sprite SPRITE = new Sprite("D", "monster_1.png");
	
	public DemonD() throws IOException {
		super(DemonD.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		behaviorType = new BehaviorOne();
	}
	
	public Boolean isAlive() {
		return null;
	}
	
	public Boolean isHero() {
		return null;
	}
	
	public void moves(int a) {
		switch(a) {
		case 1:
			this.moveRight();
			break;
		case 2:
			this.moveLeft();
			break;
		}
	}
	
	public Boolean willCollide(Point position) {
		return null;
	}
	
	public Point getNextPos(Direction direction) {
		return null;
	}
}
