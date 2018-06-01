package model.element.mobile;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Lorann extends Mobile{
	
	private Boolean alive = true;
	private Boolean hero = true;
	private Boolean mana = true;
	private Direction castDirection;
	private Spell spell;
	
	private static final Sprite SPRITE = new Sprite("L", "lorann_b.png");
	
	public Lorann() throws IOException {
		super(Lorann.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
	}
	
	public void launchSpell() {
		
	}

	public Boolean hasMana() {
		return mana;
	}

	public void setMana(Boolean mana) {
		this.mana = mana;
	}
	
	
}
