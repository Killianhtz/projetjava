package controller;



import java.awt.Point;
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
	
	public CharacterMoves(IView view,IModel model, Event event) {
        this.view = view;
		this.model = model;	
		this.event = event;
	}
	
    public void move(Boolean nextLevelY, Point direction) throws SQLException, Exception {
    	if(testPermeability(model.getElement((IMobile)model.getLorann(), direction)) == true) {
    		event.testEvent(direction);
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
}
