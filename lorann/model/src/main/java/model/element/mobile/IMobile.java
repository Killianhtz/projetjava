package model.element.mobile;

import java.awt.Point;

public interface IMobile {
	
	public void moveUp();
	public void moveDown();
	public void moveRight();
	public void moveLeft();
	public void doNothing();
	public void getX();
	public void getY();
	public Boolean isAlive();
	public Point getPosition();
}
