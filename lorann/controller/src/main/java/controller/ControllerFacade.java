package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IElement;
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
    
    private char direction = 'o';
    
    private Boolean nextLevelY = false;
    
    private int level = 1;
    
    private int score = 0;
    
    
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
        this.loop();
        
      
        
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
    
   
    
    
    public void loop() throws Exception{
    		
    	  while(test==false) {
    		  	
    		  		view.setDirection();
    		  		try {
    		  			Thread.sleep(100);
    		  		} catch (Exception e) {}
    		  		this.direction = view.getDirection();
    		  		
    		  		switch(this.direction) {
    		  		case('R'):
    		  			nextLevelY = false;
    		  			moveRight();
    		  			break;
    		  		case('L'):
    		  			nextLevelY = false;
    		  			moveLeft();
    		  			break;
    		  		case('U'):
    		  			nextLevelY = false;
    		  			moveUp();
    		  			break;
    		  		case('D'):
    		  			nextLevelY = false;
    		  			moveDown();
    		  			break;
    		  		}
    		  				  		
    		  
          }
    	  
    }
    
    
    public Boolean testPermeability(IElement element){
    	Boolean permeability = false;
    	if(element.getPermeability() == Permeability.PENETRABLE) {
    		permeability = true;
    	}
    	return permeability;
    }
    
    
    public void moveUp() throws SQLException, Exception {
    	if(testPermeability(model.getElementUp()) == true) {
    		testEventUp();
    		if(nextLevelY != true) {
        		model.moveUp();
    		}
    	}
    }
    
    public void moveDown() throws SQLException, Exception {
    	if(testPermeability(model.getElementDown()) == true) {
    		testEventDown();
    		if(nextLevelY != true) {
        		model.moveDown();
    		}
    	}
    }
    
    public void moveRight() throws Exception {
    	if(testPermeability(model.getElementRight()) == true) {
    		testEventRight();
    		if(nextLevelY != true) {
        		model.moveRight();
    		}
    	}
    }
    
    public void moveLeft() throws Exception {
    	if(testPermeability(model.getElementLeft()) == true) {
    		testEventLeft();
    		if(nextLevelY != true) {
        		model.moveLeft();
    		}
    	}
    	
    }
   
    public void testEventLeft()throws Exception {
    	switch(model.getElementLeft().getSprite().getConsoleImage()) {
    		case "E":
    			model.openGate();
    			break;
    		case "M":
    			this.level = level + 1;
    			nextLevel();
    			break;
    		case "B":
    			this.score = score + 150;
    			view.setScore(score);
    			break;
    	}
    	
    }
    
    public void testEventRight()throws Exception {
    	switch(model.getElementRight().getSprite().getConsoleImage()) {
		case "E":
			model.openGate();
			break;
		case "M":
			this.level = level + 1;
			nextLevel();
			break;
		case "B":
			this.score = score + 150;
			view.setScore(score);
			break;
	}
   }

    public void testEventUp()throws SQLException, Exception {
    	switch(model.getElementUp().getSprite().getConsoleImage()) {
		case "E":
			model.openGate();
			break;
		case "M":
			this.level = level + 1;
			nextLevel();
			break;
		case "B":
			this.score = score + 150;
			view.setScore(score);
			break;
	} 	
   }

    public void testEventDown()throws SQLException, Exception {
    	switch(model.getElementDown().getSprite().getConsoleImage()) {
		case "E":
			model.openGate();
			break;
		case "M":
			this.level = level + 1;
			nextLevel();
			break;
		case "B":
			this.score = score + 150;
			view.setScore(score);
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
}
