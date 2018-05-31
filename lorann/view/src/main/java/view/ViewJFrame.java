package view;

import java.awt.Color;
import model.IMobile;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.*;

public class ViewJFrame extends JFrame implements KeyListener{
	
	public static int 		width = 640;
	
	public static int 		height = 416;
	
	private IMobile mobile;
	
	
	
	
	public ViewJFrame(String[][] map) {
		
    	this.setTitle("Lorann");
    	this.setSize(width, height);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.addKeyListener(this);
    	this.add(new ViewJPanel(map));
    	
	}



	@Override
	public void keyPressed(KeyEvent e) {
	      if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	        System.out.println("Test");
	      else if (e.getKeyCode() == KeyEvent.VK_LEFT)
	    	  System.out.println("Test");
	      else if (e.getKeyCode() == KeyEvent.VK_DOWN)
	    	  System.out.println("Test");
	      else if (e.getKeyCode() == KeyEvent.VK_UP)
	    	  System.out.println("Test");
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
