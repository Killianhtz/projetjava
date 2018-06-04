package model.element.mobile;

import java.awt.Point;

import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;

public class Mobile extends Element implements IMobile {
	
	private Point position;
	private Point oldPosition;
	private Boolean alive = true;
	
	
	public Mobile(final Sprite SPRITE, final Permeability PERMEABILITY) {
		super(SPRITE, PERMEABILITY);
		position = new Point();
		oldPosition = new Point();
	}
	
	public void moveUp() {
		oldPosition.setLocation(getX(),getY());
		position.setLocation(position.getX(), position.getY()-1);
	}
	
	public void moveDown() {
		oldPosition.setLocation(getX(),getY());
		position.setLocation(position.getX(), position.getY()+1);
	}
	
	public void moveRight() {
		oldPosition.setLocation(getX(),getY());
		position.setLocation(position.getX()+1, position.getY());
	}
	
	public void moveLeft() {
		oldPosition.setLocation(getX(),getY());
		position.setLocation(position.getX()-1, position.getY());
	}
	public void doNothing() {
		
	}
	
	public void setPosition(int x, int y) {
		position.setLocation(x, y);;
	}
	
	public void die() {
		this.alive = false;
	}
	
	public Boolean isAlive() {
		return this.alive;
	}
	
	public int getOldX() {
		double xP = oldPosition.getX();
		int x;
		x = (int)xP;
		return x;
	}
	
	public int getOldY() {
		double yP = oldPosition.getY();
		int y;
		y = (int)yP;
		return y;
	}
	
	public int getX() {
		double xP = position.getX();
		int x;
		x = (int)xP;
		return x;
	}
	
	public int getY() {
		double yP = position.getY();
		int y;
		y = (int)yP;
		return y;
	}
	
	public Point getPosition(Point position) {
		return position.getLocation();
	}
	
}
