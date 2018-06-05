package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import model.Permeability;
import model.Sprite;

public class Spell extends Mobile{
	private static Sprite[] SPRITE = {new Sprite("Q", "fireball_1.png"),
									new Sprite("Q", "fireball_2.png"),
									new Sprite("Q", "fireball_3.png"),
									new Sprite("Q", "fireball_4.png"),
									new Sprite("Q", "fireball_5.png")};
	
	protected Point spellDirection;
	protected Point lorannPosition;
	private Boolean backLorann = false;
	

	
	public Spell(Point lorannPosition, Point spellDirection, int a) throws IOException {
		super(Spell.SPRITE[a], Permeability.PENETRABLE);
		for (int i = 0; i < SPRITE.length; i++) {
			SPRITE[i].loadImage();
		}
		this.lorannPosition = lorannPosition;
		this.spellDirection = spellDirection;
		this.setPosition((int)lorannPosition.getX() + (int)spellDirection.getX(), (int)lorannPosition.getY() + (int)spellDirection.getY());
	}
	
	public Point getSpellDirection() {
		return this.spellDirection;
	}
	
	public void setSpriteClock(int a) throws IOException {
		this.setSprite(SPRITE[a]);
	}
	
	public void setBackLorann(Boolean backLorann) {
		this.backLorann = backLorann;
	}
	
	public Boolean getBackLorann() {
		return this.backLorann;
	}
	
}
