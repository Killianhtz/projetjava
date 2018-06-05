package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
	
	private Boolean yes = false;
	
	private Image[][] image = new Image[12][20];
	
	private int score = 0;
	
	private String itslost = "";
	
	
	public ViewJPanel(String[][] map) {

	}
	
	public void changes(IElement[][] element) {
		this.yes = true;
		for (int y = 0; y <= 11; y++) {
	        for (int x = 0; x <= 19; x++) {
	        	
	       
	        
	        image[y][x] = element[y][x].getImage(); 
	        	
	        	
	        }
	    }
		repaint();
	}
	
	public void lose() {
		this.itslost = "YOU LOSE";
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	for (int y = 0; y <= 11; y++) {
        for (int x = 0; x <= 19; x++) {
        	
        	if (yes == true) {
            	g.drawImage(image[y][x], 32 * x , 32 * y , 32 , 32 , null);
			}
        	

        		
        	
        	
        }
    }
	g.setFont(new Font("impact", Font.BOLD, 50));
	g.setColor(Color.WHITE);
	g.drawString("Score : " + score, 200, 450);
	g.drawString(itslost,200,200);
}
	
	public void setScore(int score) {
		this.score = score;
	}
	

}