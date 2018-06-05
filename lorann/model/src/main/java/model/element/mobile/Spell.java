package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import javax.swing.text.Position;

import model.Permeability;
import model.Sprite;

public class Spell extends Mobile{
	private static Sprite SPRITE = new Sprite("Q", "fireball_1.png");
	protected Boolean alive;
	protected Boolean hero;
	protected Point spellDirection;
	protected Point lorannPosition;
	

	
	public Spell(Point lorannPosition, Point spellDirection) throws IOException {
		super(Spell.SPRITE, Permeability.PENETRABLE);
		SPRITE.loadImage();
		this.lorannPosition = lorannPosition;
		this.spellDirection = spellDirection;
		this.setPosition((int)lorannPosition.getX() + (int)spellDirection.getX(), (int)lorannPosition.getY() + (int)spellDirection.getY());
	}
	
	public Point getSpellDirection() {
		return this.spellDirection;
	}
}
