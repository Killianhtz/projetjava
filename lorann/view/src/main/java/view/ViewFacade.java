package view;

import javax.swing.*;
import java.awt.*;

import model.IElement;
import model.IModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	
	
	private ViewJFrame window;
	

	
	
	
	private char letter;
	
	private Boolean yesno;


	
	Image picture;
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
    	

    }

    
    
    
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	
	
	public void createJFrame(String[][] map) {
    	window = new ViewJFrame(map);
    	window.setVisible(true);
	}
	
	
	public char getDirection() {
		return window.getDirection();
	}
	
	public void setDirection() {
		window.setDirection();
	}
	
	
	public void setScore(int score) {
		window.getJPanel().setScore(score);;
	}
	
	public void setMap(IElement[][] mapef) {
		
		window.getJPanel().changes(mapef);
	}
	



    
 
    
    

}
