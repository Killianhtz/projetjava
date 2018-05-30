package model;

import model.element.IElement;

public class Map implements IMap{
	
	private int height;
	private int width;
	
	private Map() {
		
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public IElement getOnTheRoad() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
