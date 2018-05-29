package view;

import javax.swing.*;

import model.IModel;
import showboard.BoardFrame;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView, KeyListener {
	
	
	JPanel container = new JPanel();
	
	public static int 		width = 640;
	
	public static int 		height = 384;
	
	/*	The Map	*/
	private IModel			map;
	
	/*	My Pawn	*/
	private IModel			pawn;

	

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
    	super();
    	this.setTitle("Lorann");
    	this.setSize(width, height);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	container.setBackground(Color.CYAN);
    	this.setContentPane(container);
    	this.setVisible(true);
    	
    	this.addKeyListener(this);
        
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
