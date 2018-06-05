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
    private int demonZDirection = 0;
    private int demonFDirection = 0;
	private Point diffLorannDemon;
    private Boolean nextLevelY = false;
    private int clockSprite = 0;
    private int stopAndStart = 0;
	
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
 	   
 	    public void demonMovesZ(IMobile mobile) throws IOException {
 	 	   if(model.getIsThereDemonZ() == true) {
 	 		 demonZDirection = (int) (Math.random() * 4 );
 	 		   if(model.getElement(mobile, model.demonBehavior(demonZDirection, 3, mobile)).getSprite().getConsoleImage() == "V") {
 	 			   model.move(mobile, model.demonBehavior(demonZDirection, 3, mobile));
 	 		   }
 	 	 	   else if(model.getElement(mobile, model.demonBehavior(demonZDirection, 3, mobile)).getSprite().getConsoleImage() == "L") {
 	 	 		   event.lose();
 	 	 	   }
 	 	 	   
 	 		   
 	 	   }
 	   }
 	   public void demonMovesF(IMobile mobile) throws IOException {
 		   stopAndStart = (int) (Math.random() * 2);
 	 	   if(model.getIsThereDemonF() == true && stopAndStart == 1) {
 	 		this.diffLorannDemon = new Point(model.getLorann().getX()-model.getDemonFMobile().getX(),model.getLorann().getY()-model.getDemonFMobile().getY());

 	 		if(this.diffLorannDemon.getX() > 0) {
 				demonFDirection = 3;
 	 			if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "V") {
 	 			model.move(mobile, model.demonBehavior(demonFDirection, 4, mobile));
 	 			}
 	 			else if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "L") {
  	 	 		   event.lose();
  	 	 	   }
 			}
 			else if(this.diffLorannDemon.getX() < 0) {
 				demonFDirection = 2;
 				if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "V") {
 	 	 			model.move(mobile, model.demonBehavior(demonFDirection, 4, mobile));
 	 	 		}
 				else if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "L") {
  	 	 		   event.lose();
  	 	 	   }
 			}
 			if(this.diffLorannDemon.getY() < 0) {
 				demonFDirection = 0;
 				if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "V") {
 	 	 			model.move(mobile, model.demonBehavior(demonFDirection, 4, mobile));
 	 	 		}
 				else if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "L") {
  	 	 		   event.lose();
  	 	 	   }
 			}
 			else if(this.diffLorannDemon.getY() > 0) {
 				demonFDirection = 1;
 				if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "V") {
 	 	 			model.move(mobile, model.demonBehavior(demonFDirection, 4, mobile));
 	 	 		}
 				else if(model.getElement(mobile, model.demonBehavior(demonFDirection, 4, mobile)).getSprite().getConsoleImage() == "L") {
  	 	 		   event.lose();
  	 	 	   }
 			}
 	 		
 	 		   
 	 	  }
 	   }
    public void setNextLevelY(Boolean nextLevelY) {
  	  this.nextLevelY = nextLevelY;
      }
     
}
