package model.element.mobile;

import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Lorann extends Mobile{
	
	private Boolean mana = true;
	private Direction castDirection;
	//private Spell spell;
	
	private static final Sprite[] SPRITE = {new Sprite("L", "lorann_b.png"),
											new Sprite("L", "lorann_bl.png"),
											new Sprite("L", "lorann_l.png"),
											new Sprite("L", "lorann_ul.png"),
											new Sprite("L", "lorann_u.png"),
											new Sprite("L", "lorann_ur.png"),
											new Sprite("L", "lorann_r.png"),
											new Sprite("L", "lorann_br.png")};
	
	
	public Lorann(int a) throws IOException {
		super(Lorann.SPRITE[a], Permeability.PENETRABLE);
		for (int i = 0; i < SPRITE.length; i++) {
			SPRITE[i].loadImage();
		}
	}

	public Boolean hasMana() {
		return mana;
	}

	public void setMana(Boolean mana) {
		this.mana = mana;
	}
	
	public Direction getCastDirection() {
		return this.castDirection;
	}
	
	public void setSpriteClock(int a) throws IOException {
		this.setSprite(SPRITE[a]);
	}
	
}
