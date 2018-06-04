package model;

import java.awt.Point;


public interface IMobile {
	
	/*public void moveUp();
	public void moveDown();
	public void moveRight();
	public void moveLeft();*/
	void move(Point playerMoves);
	public void doNothing();
	public int getOldX();
	public int getOldY();
	public int getX();
	public int getY();
	public void setPosition(int x, int y);
	public Boolean isAlive();
	public Point getPosition(Point position);
}
