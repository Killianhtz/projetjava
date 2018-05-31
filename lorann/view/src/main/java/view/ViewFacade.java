package view;

import javax.swing.*;
import java.awt.*;

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
	

	
	/*	The Map	*/
	private IModel			mapef;
	
	/*	My Pawn	*/
	private IModel			pawn;
	
	private char letter;
	
	


	
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
		this.letter = window.getDirection();
		return letter;
	}
	
	
	private IModel getPawn() {
		return this.pawn;
	}
	
	
	private void setPawn(IModel pawn) {
		this.pawn = pawn;
	}
	



    
 
    
    

}
