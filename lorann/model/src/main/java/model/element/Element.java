package model.element;

import java.awt.Image;

import model.IElement;
import model.Permeability;
import model.Sprite;

public class Element implements IElement {

	private Sprite sprite;
	private Permeability permeability;
	
	public Element(Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
        this.setPermeability(permeability);
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Permeability getPermeability() {
		return this.permeability;
	}
	
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public Image getImage() {
		return getSprite().getImage();
	}
	
}
