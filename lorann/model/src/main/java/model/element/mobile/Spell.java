package model.element.mobile;

import java.awt.Point;

import javax.swing.text.Position;

import model.Permeability;
import model.Sprite;

public class Spell extends Mobile{
	
	protected Boolean alive;
	protected Boolean hero;
	protected Behavior behavior;
	protected Point spellDirection;
	protected Point lorannPosition;
	
	private static Sprite sprite = new Sprite("Q", "fireball_1.jpg");
	
	public Spell(Point lorannPosition, Point spellDirection) {
		super(Spell.sprite, Permeability.PENETRABLE);
		this.lorannPosition = lorannPosition;
		this.spellDirection = spellDirection;
		this.alive = false;
		this.hero = false;
		this.setPosition((int)lorannPosition.getX() + (int)spellDirection.getX(), (int)lorannPosition.getY() + (int)spellDirection.getY());
		
	}
	
	public Point getSpellDirection() {
		return this.spellDirection;
	}
}
