package controller;

import java.awt.Point;
import java.io.IOException;

import model.IMobile;
import model.IModel;

public class CastingSpell {
	private IModel model;
	private Event event;
	private Point lastDirection;
	private Point diffLorannSpell;
	private Point newDirection;
	private int clockSprite = 0;
	
	public CastingSpell(IModel model, Event event) {
		this.model = model;	
		this.event = event;
	}
	
	
	
	public void createSpell(Point lastDirection) throws IOException {
		if(model.hasMana() == true) {
			if(model.getElement((IMobile)model.getLorann(), lastDirection).getSprite().getConsoleImage() == "V") {
				this.lastDirection = new Point();
				this.lastDirection = lastDirection;
				model.creatSpell(lastDirection);
				model.setMana(false);
			}
			
		}
		
	}
	
	public void moveSpell() throws Exception {
		model.setSpriteClockSpell(clockSprite);
		clockSprite++;		
		if(clockSprite == 5) {
			clockSprite = 0;
		}
		if(model.getElement(model.getSpell(), this.lastDirection).getSprite().getConsoleImage() == "V") {
			model.move(model.getSpell(), this.lastDirection);
		}
		else if(model.getElement(model.getSpell(), this.lastDirection).getSprite().getConsoleImage() == "D") {
			this.spellDemonEventD();
		}
		else if(model.getElement(model.getSpell(), this.lastDirection).getSprite().getConsoleImage() == "X") {
			this.spellDemonEventX();
		}
		else if(model.getElement(model.getSpell(), this.lastDirection).getSprite().getConsoleImage() == "Z") {
			this.spellDemonEventZ();
		}
		else if(model.getElement(model.getSpell(), this.lastDirection).getSprite().getConsoleImage() == "F") {
			this.spellDemonEventF();
		}
		else if(model.getElement(model.getSpell(), this.lastDirection).getSprite().getConsoleImage() == "L") {
			model.disappear(model.getSpell());
			model.setMana(true);
		}
		else {
			this.lastDirection.setLocation(0 - this.lastDirection.getX(), 0 - this.lastDirection.getY());
		}
		
	}
	
	public void moveSpell(Boolean backLorann) throws Exception {
		model.setSpriteClockSpell(clockSprite);
		clockSprite++;		
		if(clockSprite == 5) {
			clockSprite = 0;
		}
	
	    diagonalMoves();
		
		
		
		
		if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "V") {
			model.move(model.getSpell(), this.newDirection);
		}
		else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "D") {
			this.spellDemonEventD();
		}
		else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "X") {
			this.spellDemonEventX();
		}
		else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "Z") {
			this.spellDemonEventZ();
		}
		else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "F") {
			this.spellDemonEventF();
		}
		else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "L") {
			model.disappear(model.getSpell());
			model.setMana(true);
		}
		else {
			horizontalMoves();
			if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "V") {
				model.move(model.getSpell(), this.newDirection);
			}
			else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "D") {
				this.spellDemonEventD();
			}
			else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "X") {
				this.spellDemonEventX();
			}
			else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "Z") {
				this.spellDemonEventZ();
			}
			else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "F") {
				this.spellDemonEventF();
			}
			else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "L") {
				model.disappear(model.getSpell());
				model.setMana(true);
			}
			else {
				verticalMoves();
				if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "V") {
					model.move(model.getSpell(), this.newDirection);
				}
				else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "D") {
					this.spellDemonEventD();
				}
				else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "X") {
					this.spellDemonEventX();
				}
				else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "Z") {
					this.spellDemonEventZ();
				}
				else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "F") {
					this.spellDemonEventF();
				}
				else if(model.getElement(model.getSpell(), this.newDirection).getSprite().getConsoleImage() == "L") {
					model.disappear(model.getSpell());
					model.setMana(true);
				}
			}
		}
		
		
		
	}
	
	public void diagonalMoves() {
		
		this.newDirection = new Point();
		this.diffLorannSpell = new Point(model.getLorann().getX()-model.getSpell().getX(),model.getLorann().getY()-model.getSpell().getY());
		
		if(this.diffLorannSpell.getX() > 0 &&  this.diffLorannSpell.getY() > 0) {
			this.newDirection.setLocation(1,1);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
		else if(this.diffLorannSpell.getX() < 0 &&  this.diffLorannSpell.getY() > 0) {
			this.newDirection.setLocation(-1,1);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
		else if(this.diffLorannSpell.getX() > 0 &&  this.diffLorannSpell.getY() < 0) {
			this.newDirection.setLocation(1,-1);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
		else if(this.diffLorannSpell.getX() < 0 &&  this.diffLorannSpell.getY() < 0) {
			this.newDirection.setLocation(-1,-1);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
	}
	
	public void horizontalMoves() {
		if(this.diffLorannSpell.getX() > 0) {
			this.newDirection.setLocation(1,0);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
		else if(this.diffLorannSpell.getX() < 0) {
			this.newDirection.setLocation(-1,0);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
	}
	
	public void verticalMoves() {
		if(this.diffLorannSpell.getY() > 0) {
			this.newDirection.setLocation(0,1);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
		else if(this.diffLorannSpell.getY() < 0) {
			this.newDirection.setLocation(0,-1);
			this.diffLorannSpell.setLocation(this.diffLorannSpell.getX() - this.newDirection.getX(),this.diffLorannSpell.getY() -  this.newDirection.getY());
		}
	}
	
	public void spellDemonEventD() throws IOException {
		model.disappear(model.getDemonDMobile());
		model.disappear(model.getSpell());
		model.setDemonDownD(false);
		event.newScore(100);
		model.setMana(true);
	}
	public void spellDemonEventX() throws Exception {
		model.disappear(model.getDemonXMobile());
		model.disappear(model.getSpell());
		model.setDemonDownX(false);
		event.newScore(100);
		model.setMana(true);
	}
	public void spellDemonEventZ() throws IOException {
		model.disappear(model.getDemonZMobile());
		model.disappear(model.getSpell());
		model.setDemonDownZ(false);
		event.newScore(100);
		model.setMana(true);
	}
	public void spellDemonEventF() throws IOException {
		model.disappear(model.getDemonFMobile());
		model.disappear(model.getSpell());
		model.setDemonDownF(false);
		event.newScore(100);
		model.setMana(true);
	}
	
}
