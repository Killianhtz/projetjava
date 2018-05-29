package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

public class ViewJFrame extends JFrame {
	
	public static int 		width = 640;
	
	public static int 		height = 384;
	
	
	
	public ViewJFrame() {
    	this.setTitle("Lorann");
    	this.setSize(width, height);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
	}
	
}
