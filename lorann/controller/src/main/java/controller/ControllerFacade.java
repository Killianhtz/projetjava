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
    private CharacterMoves characterMoves;
    private CastingSpell castingSpell;
    
    private Boolean test = false;
    
    private Point direction;
    private Point lastDirection;
    private Point direction2;
    
    private Boolean nextLevelY = false;
    
    private int level = 1;
    

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
        characterMoves = new CharacterMoves(view,model,event);
        castingSpell = new CastingSpell(view,model,event);
        
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
  		  if(this.direction.getX() != 0 || this.direction.getY() != 0) {
  			  this.lastDirection = this.direction;
  			  System.out.println(this.direction);
  		  }
  		  
		if(view.getSpell() == true) {
			castingSpell.createSpell(lastDirection);
			view.setSpell();
		}
		characterMoves.move(nextLevelY,direction);
  		 characterMoves.demonMovesD(model.getDemonDMobile());
  		characterMoves.demonMovesX(model.getDemonXMobile());
        }
        
      
        
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
