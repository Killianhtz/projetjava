package model.element.mobile;

import javax.swing.text.Position;

import model.Permeability;
import model.Sprite;

public class Spell extends Mobile{
	
	protected Boolean alive;
	protected Boolean hero;
	protected Behavior behavior;
	protected Direction direction;
	
	private static Sprite sprite = new Sprite("Q", "fireball_1.jpg");
	
	public Spell(Position lorannPosition, Direction spellDirection) {
		super(Spell.sprite, Permeability.PENETRABLE);
		this.alive = false;
		this.hero = false;
		
		
	}
}
