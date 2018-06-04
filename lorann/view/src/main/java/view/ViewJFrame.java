package view;

import java.awt.Color;
import java.awt.Point;

import model.IMobile;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.*;

public class ViewJFrame extends JFrame implements KeyListener{
	
	public static int 		width = 640;
	
	public static int 		height = 515;
	
	private ViewJPanel viewjpanel;
	
	private char letter = 'O';
	
	private Point playerMoves = new Point(0,0);
	
	
	
	
	public ViewJFrame(String[][] map) {
		
    	this.setTitle("Lorann");
    	this.setSize(width, height);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.addKeyListener(this);
    	this.viewjpanel = new ViewJPanel(map);
    	this.viewjpanel.setBackground(Color.BLACK);
    	this.add(viewjpanel);
    	
    	
	}



	@Override
	public void keyPressed(KeyEvent e) {
	      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	  playerMoves.x = 1;
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	  playerMoves.x = -1;
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	  playerMoves.y = 1;
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	  playerMoves.y = -1;
	      }
	      else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	 // this.letter = 'S';
	      }
	      
		
	} 



	@Override
	public void keyReleased(KeyEvent e) {

		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public Point getDirection() {
		return playerMoves;
	}
	
	public void setDirection() {
		playerMoves.x = 0;
		playerMoves.y = 0;
	}
	
	public ViewJPanel getJPanel() {
		return this.viewjpanel;
	}
}
