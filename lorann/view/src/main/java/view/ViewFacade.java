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
public class ViewFacade implements IView, KeyListener {
	
	
	private ViewJFrame window;
	

	
	/*	The Map	*/
	private IModel			map;
	
	/*	My Pawn	*/
	private IModel			pawn;

	
	Image picture;
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
    	
    	window = new ViewJFrame();
    	window.add(new ViewJPanel());
    	window.setVisible(true);
        
    }

    
    
    
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	private IModel getMap() {
		return this.map;
	}
	
	
	private void setMap() {
		/* A COMPLETER */
	}
	
	
	private IModel getPawn() {
		return this.pawn;
	}
	
	
	private void setPawn(IModel pawn) {
		this.pawn = pawn;
	}


    
 
    
    

}
