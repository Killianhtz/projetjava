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
	
	private char letter = 'O';
	
	
	
	
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
	      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	  this.letter = 'R';
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	  this.letter = 'L';
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	  this.letter = 'D';
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	  this.letter = 'U';
	      }
		
	} 



	@Override
	public void keyReleased(KeyEvent e) {

		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public char getDirection() {
		return this.letter;
	}
	
	public void setDirection() {
		this.letter = 'O';
	}
}
