package controller;

import java.awt.Point;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Example;
import model.IModel;
import view.IView;


public class ControllerFacade implements IController, Observer {

 
    private final IView  view;
    private final IModel model;
    private Event event;
    private CharacterMoves characterMoves;
    private CastingSpell castingSpell;
    
    private Boolean test = false;
    
    private Point direction;
    private Point lastDirection;
    
    private int level = 1;
    

    public String[][] map = new String[12][20];
    
    private int x = 0;
    private int y = 0;
    private int xc = 0;
    private int yc = 0;


    public ControllerFacade(final IView view, final IModel model) throws Exception {
        super();
        this.view = view;
        this.model = model;
        model.setView(view);
        event = new Event(view,model);
        event.addObserver(this);
        characterMoves = new CharacterMoves(view,model,event);
        castingSpell = new CastingSpell(model,event);
		  if ((x < 0) || (x > 20)) {
		  throw new Exception("Out of range");
		  }
		  if ((xc < 0) || (xc > 20)) {
		  throw new Exception("Out of range");
		  }
		  if ((y < 0) || (y > 12)) {
		  throw new Exception("Out of range");
		  }
		  if ((yc < 0) || (yc > 12)) {
		  throw new Exception("Out of range");
		  }
    }

   	/**
	 * The loop where all the moves methods are used
	 */

    public void play() throws Exception {
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
  		  characterMoves.setNextLevelY(false);
  		  view.setDirection();
  		  try {
  		  	Thread.sleep(150);
  		  } catch (Exception e) {}
  		  this.direction = view.getDirection();
  		  if(this.direction.getX() != 0 || this.direction.getY() != 0) {
  			  yc = (int) this.direction.getY();
  			  xc = (int) this.direction.getX();
  		  }
  		  
		
		
		characterMoves.move(direction);
  		characterMoves.demonMovesD(model.getDemonDMobile());
  		characterMoves.demonMovesX(model.getDemonXMobile());
  		characterMoves.demonMovesZ(model.getDemonZMobile());
  		characterMoves.demonMovesF(model.getDemonFMobile());
  		
  		if(model.hasMana() == false ) {
  			if(view.getSpell() == true) {
  				model.setBackLorann(true);
  			}	
  			
  			if(model.getBackLorann() == true) {

				castingSpell.moveSpell(view.getSpell());
  			}
  			else {
  				castingSpell.moveSpell();
  			}
  		}
  		
  		if(view.getSpell() == true) {
			lastDirection = new Point(xc,yc);
			castingSpell.createSpell(this.lastDirection);
			view.setSpell();
  			}
        }
  
    }
   	/**
	 	* Method use to go to the next level
	 	*/
    
    public void nextLevel() throws SQLException, Exception {
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
 
   	/**
	 * Method who come from the DP observer, who notify when we have to change the map
	 */
	@Override
	public void update(Observable o, Object arg) {
		
                try {
					nextLevel();
				} catch (Exception e) {
					e.printStackTrace();
				}
                characterMoves.setNextLevelY(true);
        
	}
}
