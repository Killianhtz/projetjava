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

        final List<Example> procedure = this.getModel().getMapByLevel(1);
        final StringBuilder message = new StringBuilder();
        for (final Example example : procedure) {
            message.append(example);
            message.append('\n');
            map[y][x] = example.getElement();
            x++;
            if(x == 20) {
            	y++;
            	x = 0;
            }
        }
        
        

        
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
    
   
    
    
    public void loop() throws IOException{
    		
    	  while(test==false) {
    		  	
    		  		view.setDirection();
    		  		try {
    		  			Thread.sleep(100);
    		  		} catch (Exception e) {}
    		  		this.direction = view.getDirection();
    		  		
    		  		switch(this.direction) {
    		  		case('R'):
    		  			moveRight();
    		  			break;
    		  		case('L'):
    		  			moveLeft();
    		  			break;
    		  		case('U'):
    		  			moveUp();
    		  			break;
    		  		case('D'):
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
    
    
    public void moveUp() throws IOException {
    	if(testPermeability(model.getElementUp()) == true) {
    		testEventUp();
    		model.moveUp();
    	}
    }
    
    public void moveDown() throws IOException {
    	if(testPermeability(model.getElementDown()) == true) {
    		testEventDown();
    		model.moveDown();
    	}
    }
    
    public void moveRight() throws IOException {
    	if(testPermeability(model.getElementRight()) == true) {
    		testEventRight();
        	model.moveRight();
    	}
    }
    
    public void moveLeft() throws IOException {
    	if(testPermeability(model.getElementLeft()) == true) {
    		testEventLeft();
    		model.moveLeft();
    	}
    	
    }
   
    public void testEventLeft()throws IOException {
    	if(model.getElementLeft().getSprite().getConsoleImage() == "E") {
    		model.openGate();
    	}
    }
    
    public void testEventRight()throws IOException {
    	if(model.getElementRight().getSprite().getConsoleImage() == "E") {
    		model.openGate();
    	}
    }

    public void testEventUp()throws IOException {
    	if(model.getElementUp().getSprite().getConsoleImage() == "E") {
    		model.openGate();
    	}
    }

    public void testEventDown()throws IOException {
    	if(model.getElementDown().getSprite().getConsoleImage() == "E") {
    		model.openGate();
    	}
    }
}
