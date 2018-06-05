package controller;



import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;

import model.IElement;
import model.IMobile;
import model.IModel;
import model.Permeability;
import view.IView;

public class CharacterMoves {
	private IModel model;
	private IView view;
	private Event event;
    private int demonDDirection = 0;
    private int demonXDirection = 0;
    private Boolean nextLevelY = false;
    private int clockSprite = 0;
	
	public CharacterMoves(IView view,IModel model, Event event) {
        this.view = view;
		this.model = model;	
		this.event = event;
	}
	
    public void move(Point direction) throws SQLException, Exception {
    	event.testEvent(direction);
    	if(direction.getX() == 0 && direction.getY() == 0) {
    		model.setSpriteClock(clockSprite);
    		clockSprite++;		
    		if(clockSprite == 8) {
    			clockSprite = 0;
    		}
    	}
    	if(testPermeability(model.getElement((IMobile)model.getLorann(), direction)) == true) {
    		
    		if(nextLevelY != true) {
        		model.move(model.getLorann(), direction);
        		
    		}
    	}
    	view.setDirection();
    	
    }
    
    public Boolean testPermeability(IElement element){
    	Boolean permeability = false;
    	if(element.getPermeability() == Permeability.PENETRABLE) {
    		permeability = true;
    	}
    	return permeability;
    }
    
    public void demonMovesD(IMobile mobile) throws IOException {
    	if(model.getIsThereDemonD() == true) {
    		if(model.getElement(mobile, model.demonBehavior(demonDDirection, 1, mobile)).getSprite().getConsoleImage() == "V") {
    	 		   model.move(mobile, model.demonBehavior(demonDDirection, 1, mobile));
    	 	   }
    	 	   else if(model.getElement(mobile, model.demonBehavior(demonDDirection, 1, mobile)).getSprite().getConsoleImage() == "L") {
    	 		   event.lose();
    	 	   }
    	 	   else {
    	 		   demonDDirection++;
    	 		   if(demonDDirection == 6) {
    	 			   demonDDirection = 0;
    	 		   }
    	 	   }	
    	}
 	   
     }
    public void demonMovesX(IMobile mobile) throws IOException {
 	   if(model.getIsThereDemonX() == true) {
 		   if(model.getElement(mobile, model.demonBehavior(demonXDirection, 2, mobile)).getSprite().getConsoleImage() == "V") {
 			   model.move(mobile, model.demonBehavior(demonXDirection, 2, mobile));
 		   }
 	 	   else if(model.getElement(mobile, model.demonBehavior(demonXDirection, 2, mobile)).getSprite().getConsoleImage() == "L") {
 	 		   event.lose();
 	 	   }
 		   else {
 			   demonXDirection++;
 			   if(demonXDirection == 6) {
 				   demonXDirection = 0;
 			   }
 		   }
 	   }
 	   
     }
    public void setNextLevelY(Boolean nextLevelY) {
  	  this.nextLevelY = nextLevelY;
      }
     
}
