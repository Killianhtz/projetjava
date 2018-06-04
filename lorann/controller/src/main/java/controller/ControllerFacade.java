package controller;

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
    
    private char direction = 'o';
    
    private Boolean nextLevelY = false;
    
    private int level = 1;
    
    private int score = 0;
    
    private int demonDDirection = 1;
    private int demonXDirection = 1;
    
    
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
    		  			Thread.sleep(150);
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
    		  		case('S'):
    		  			nextLevelY = false;
    		  			break;
    		  		}
    		  				  		
    		 demonMoves();
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
    	if(testPermeability(model.getElementUp((IMobile)model.getLorann())) == true) {
    		testEventUp();
    		if(nextLevelY != true) {
        		model.moveUp(model.getLorann());
    		}
    	}
    }
    
    public void moveDown() throws SQLException, Exception {
    	if(testPermeability(model.getElementDown(model.getLorann())) == true) {
    		testEventDown();
    		if(nextLevelY != true) {
        		model.moveDown(model.getLorann());
    		}
    	}
    }
    
    public void moveRight() throws Exception {
    	if(testPermeability(model.getElementRight(model.getLorann())) == true) {
    		testEventRight();
    		if(nextLevelY != true) {
        		model.moveRight(model.getLorann());
    		}
    	}
    }
    
    public void moveLeft() throws Exception {
    	if(testPermeability(model.getElementLeft(model.getLorann())) == true) {
    		testEventLeft();
    		if(nextLevelY != true) {
        		model.moveLeft(model.getLorann());
    		}
    	}
    	
    }
   
    public void testEventLeft()throws Exception {
    	switch(model.getElementLeft(model.getLorann()).getSprite().getConsoleImage()) {
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
    
    public void testEventRight()throws Exception {
    	switch(model.getElementRight(model.getLorann()).getSprite().getConsoleImage()) {
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

    public void testEventUp()throws SQLException, Exception {
    	switch(model.getElementUp(model.getLorann()).getSprite().getConsoleImage()) {
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

    public void testEventDown()throws SQLException, Exception {
    	switch(model.getElementDown(model.getLorann()).getSprite().getConsoleImage()) {
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
    
    public void castSpell() {
    	
    	if (this.model.spellAlive()) {
			
		}
    }
    
    public void spellMoves() {
    	
    }
    
    public void demonDMoves() throws IOException {
    	if(model.getElementRight(model.getDemonD()).getSprite().getConsoleImage() == "V" && this.demonDDirection == 1) {
    		model.moveRight(model.getDemonD());
    	}
    	else if(model.getElementLeft(model.getDemonD()).getSprite().getConsoleImage() == "V" && this.demonDDirection == 2) {
    		model.moveLeft(model.getDemonD());
    	}
    	else if(model.getElementRight(model.getDemonD()).getSprite().getConsoleImage() == "L" && this.demonDDirection == 1) {
    		lose();
    	}
    	else if(model.getElementLeft(model.getDemonD()).getSprite().getConsoleImage() == "L" && this.demonDDirection == 2) {
    		lose();
    	}
    	else if(model.getElementRight(model.getDemonD()).getSprite().getConsoleImage() != "V" && this.demonDDirection == 1) {
    		this.demonDDirection = 2;
    	}
    	else if(model.getElementLeft(model.getDemonD()).getSprite().getConsoleImage() != "V" && this.demonDDirection == 2) {
    		this.demonDDirection = 1;
    	}
    }
    
    public void demonXMoves() throws IOException {
    	if(model.getElementUp(model.getDemonX()).getSprite().getConsoleImage() == "V" && this.demonXDirection == 1) {
    		model.moveUp(model.getDemonX());
    	}
    	else if(model.getElementDown(model.getDemonX()).getSprite().getConsoleImage() == "V" && this.demonXDirection == 2) {
    		model.moveDown(model.getDemonX());
    	}
    	else if(model.getElementUp(model.getDemonX()).getSprite().getConsoleImage() == "L" && this.demonXDirection == 1) {
    		lose();
    	}
    	else if(model.getElementDown(model.getDemonX()).getSprite().getConsoleImage() == "L" && this.demonXDirection == 2) {
    		lose();
    	}
    	else if(model.getElementUp(model.getDemonX()).getSprite().getConsoleImage() != "V" && this.demonXDirection == 1) {
    		this.demonXDirection = 2;
    	}
    	else if(model.getElementDown(model.getDemonX()).getSprite().getConsoleImage() != "V" && this.demonXDirection == 2) {
    		this.demonXDirection = 1;
    	}
    }
    
    public void demonMoves() throws IOException{
		 demonDMoves();
		 if(model.isThereDemonX() == true) {
			 demonXMoves();
		 }
		 
    }
    
    public void lose() {
    	this.view.lose();
    	while(true) {
    		
    	}
    }
}
