package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
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
    }

    /**
     * Start.
     * @throws Exception 
     */
    public void play() throws Exception {
        //this.getView().displayMessage(this.getModel().getExampleById(1).toString());
    	 

        //this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> procedure = this.getModel().getMapByLevel(2);
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
        
        
        for (int y = 0; y < 12; y++) {
        	
        	for (int x = 0; x < 20; x++) {
				System.out.print(map[y][x]);
			}
        	System.out.println("");
			
		}
        
        view.createJFrame(map);
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
    
    public void loop() {
    	  while(test==false) {
    		  	
    		  		view.setDirection();
    		  		try {
    		  			Thread.sleep(100);
    		  		} catch (Exception e) {}
    		  		this.direction = view.getDirection();
    		  		if(this.direction != 'O')
    		  			System.out.println(this.direction);
    		  		
    		  		
    		  	

    		  
    		  
    		  
          }
    }
   
}
