package model;

import java.awt.Point;

public interface IMobile {
	
	public void moveUp();
	public void moveDown();
	public void moveRight();
	public void moveLeft();
	public void doNothing();
	public int getX(Point position);
	public int getY(Point position);
	public Boolean isAlive();
	public Point getPosition(Point position);
}
