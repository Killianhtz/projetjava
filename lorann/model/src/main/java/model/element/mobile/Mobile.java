package model.element.mobile;

import java.awt.Point;

import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;

public class Mobile extends Element implements IMobile {
	
	private Point position;
	private Boolean alive = true;
	
	public Mobile(Sprite sprite, IMap map, Permeability permeability) {
		
	}
	
	public void moveUp() {
		position.translate(0, -1);
	}
	
	public void moveDown() {
		position.translate(0, 1);
	}
	
	public void moveRight() {
		 position.translate(1, 0);
	}
	
	public void moveLeft() {
		position.translate(-1, 0);
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
