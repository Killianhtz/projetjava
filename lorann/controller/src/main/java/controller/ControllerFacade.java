package controller;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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
public class ControllerFacade implements IController, Observer {

 
    private final IView  view;
    private final IModel model;
    private Event event;
    
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


    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        model.setView(view);
        event = new Event(view,model);
        event.addObserver(this);
    }

    /**
     * Start.
     * @throws Exception 
     */
    public void play() throws Exception {
    	direction2 = new Point(0,0);
        final List<Example> procedure = this.model.getMapByLevel(level);
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



    
    
    public Boolean testPermeability(IElement element){
    	Boolean permeability = false;
    	if(element.getPermeability() == Permeability.PENETRABLE) {
    		permeability = true;
    	}
    	return permeability;
    }
    
    
    public void move() throws SQLException, Exception {
    	if(testPermeability(model.getElement((IMobile)model.getLorann(), direction)) == true) {
    		event.testEventUp(direction);
    		if(nextLevelY != true) {
        		model.move(model.getLorann(), direction);
        		
    		}
    	}
    	view.setDirection();
    }
 
    
    public void nextLevel() throws SQLException, Exception {
    	nextLevelY = true;
    	level++;
    	final List<Example> procedure = this.model.getMapByLevel(level);
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

	@Override
	public void update(Observable o, Object arg) {
		
                try {
					nextLevel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        
	}
}
