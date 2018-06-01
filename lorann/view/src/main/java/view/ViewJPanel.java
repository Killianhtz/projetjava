package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.IController;
import model.IElement;

public class ViewJPanel extends JPanel {
	
	private String[][] map;
	
	private IController controller;
	
	private Boolean oui = false;
	
	private BufferedImage[][] image = new BufferedImage[12][20];
	
	
	public ViewJPanel(String[][] map) {

	}
	
	public void changes(IElement[][] element) {
		this.oui = true;
		for (int y = 0; y <= 11; y++) {
	        for (int x = 0; x <= 19; x++) {
	        	
	        	
	        	
	        image[y][x] = (BufferedImage)element[y][x].getImage(); 
	        	
	        	
	        }
	    }
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	for (int y = 0; y <= 11; y++) {
        for (int x = 0; x <= 19; x++) {
        	
        	if (oui == true) {
            	g.drawImage(image[y][x], 32 * x , 32 * y , 32 , 32 , null);
			}
        	

        		
        	
        	
        }
    }
	

}
	

}