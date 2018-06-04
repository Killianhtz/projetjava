package controller;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IElement;
import model.IMobile;
import model.IModel;
import model.Permeability;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    private Boolean test = false;
    
    private Point direction;
    private Point direction2;
    
    private Boolean nextLevelY = false;
    
    private int level = 1;
    
    private int score = 0;
    
    private int demonDDirection = 0;
    private int demonXDirection = 0;
    
    
    /* Map */
    public String[][] map = new String[12][20];
    
    private int x = 0;
    private int y = 0;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        model.setView(view);
    }

    /**
     * Start.
     * @throws Exception 
     */
    public void play() throws Exception {
    	direction2 = new Point(0,0);
        final List<Example> procedure = this.getModel().getMapByLevel(level);
        for (final Example example : procedure) {
            map[y][x] = example.getElement();
            x++;
            if(x == 20) {
            	y++;
            	x = 0;
            }
        }
        
        x = 0;
        y = 0;

        
        view.createJFrame(map);
        model.constructTheMap(map);
        
        while(test==false) {
  		  nextLevelY = false;
  		  view.setDirection();
  		  try {
  		  	Thread.sleep(150);
  		  } catch (Exception e) {}
  		  this.direction = view.getDirection();
  		  		
  		  move();
			  		
  		 demonMoves(model.getDemonDMobile());
        }
        
      
        
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    
    
    public Boolean testPermeability(IElement element){
    	Boolean permeability = false;
    	if(element.getPermeability() == Permeability.PENETRABLE) {
    		permeability = true;
    	}
    	return permeability;
    }
    
    
    public void move() throws SQLException, Exception {
    	if(testPermeability(model.getElement((IMobile)model.getLorann(), direction)) == true) {
    		testEventUp();
    		if(nextLevelY != true) {
        		model.move(model.getLorann(), direction);
        		
    		}
    	}
    	view.setDirection();
    }

    public void testEventUp()throws SQLException, Exception {
    	switch(model.getElement(model.getLorann(), direction).getSprite().getConsoleImage()) {
		case "E":
			model.openGate(model.getLorann());
			break;
		case "M":
			this.level = level + 1;
			nextLevel();
			break;
		case "B":
			addScore();
			view.setScore(score);
			break;
		case "D":
			lose();
			break;
		case "X":
			lose();
			break;
	} 	
   }

    
    
    public void nextLevel() throws SQLException, Exception {
    	nextLevelY = true;
    	final List<Example> procedure = this.getModel().getMapByLevel(level);
        for (final Example example : procedure) {
            map[y][x] = example.getElement();
            x++;
            if(x == 20) {
            	y++;
            	x = 0;
            }
        }
        
        x = 0;
        y = 0;

        model.constructTheMap(map);
        
    }
    
    public void addScore() {
    	this.score = this.score + 650;
    }
    
    
    
    public void spellMoves() {
    	
    }
    
   public void demonMoves(IMobile mobile) throws IOException {
	   if(model.getElement(mobile, model.demonBehavior(demonDDirection, mobile)).getSprite().getConsoleImage() == "V") {
		   model.move(mobile, model.demonBehavior(demonDDirection, mobile));
	   }
	   else {
		   demonDDirection++;
		   if(demonDDirection == 6) {
			   demonDDirection = 0;
		   }
	   }
	   
    	
    }

    
    public void lose() {
    	this.view.lose();
    	while(true) {
    		
    	}
    }
}
