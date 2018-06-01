package model.element.mobile;

import java.awt.Point;

import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;

public class Mobile extends Element implements IMobile {
	
	private Point position;
	private Boolean alive = true;
	
	public Mobile(final Sprite SPRITE, final Permeability PERMEABILITY) {
		super(SPRITE, PERMEABILITY);
	}
	
	public void moveUp() {
		position.setLocation(position.getX(), position.getY()-1);
	}
	
	public void moveDown() {
		position.setLocation(position.getX(), position.getY()+1);
	}
	
	public void moveRight() {
		position.setLocation(position.getX()+1, position.getY());
	}
	
	public void moveLeft() {
		position.setLocation(position.getX()-1, position.getY());
	}
	public void doNothing() {
		
	}
	
	public void die() {
		this.alive = false;
	}
	
	public Boolean isAlive() {
		return this.alive;
	}
	
	public int getX(Point position) {
		double xP = position.getX();
		int x;
		x = (int)xP;
		return x;
	}
	
	public int getY(Point position) {
		double yP = position.getY();
		int y;
		y = (int)yP;
		return y;
	}
	
	public Point getPosition(Point position) {
		return position.getLocation();
	}

}
