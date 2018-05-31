package model.element.mobile;

import java.awt.Point;

import model.IMap;
import model.IMobile;
import model.element.Permeability;
import model.element.Sprite;

public class Mobile implements IMobile {
	

	private int x;
	private int y;
	private Point position;
	private Boolean alive = true;
	
	protected Mobile(Sprite sprite, IMap map, Permeability permability) {
	    }
	
	public void moveTo(int x,int y){
        this.x=x;
        this.y=y;
	}
        

	public void moveUp() {
	
		moveTo(this.x ,this.y-1);
	}
	
	public void moveDown() {
		
		moveTo(this.x ,this.y+1);

	}
	
	public void moveLeft() {
		
		moveTo(this.x-1 ,this.y);
	}
	
	public void moveRight() {
		
		moveTo(this.x+1 ,this.y);
	}
		
	
    public void moveUpRight() {
    	
        moveTo(this.x+1 ,this.y-1);
	}
	
    public void moveUpLeft() {
    	
        moveTo(this.x-1 ,this.y-1);  
    }
    
    public void moveDownLeft() {
    	
    
        moveTo(this.x-1 ,this.y+1);
      
    }
    
    public void moveDownRight() {
    	
        moveTo(this.x+1 ,this.y+1);
        
    }
        
	public void doNothing() {
		
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Boolean isAlive() {
		return alive;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	protected void die() {
		
	}
}
