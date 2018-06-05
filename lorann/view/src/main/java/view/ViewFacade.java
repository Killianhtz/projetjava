package view;


import java.awt.*;

import model.IElement;



public class ViewFacade implements IView {
	
	
	private ViewJFrame window;
	Image picture;

    public ViewFacade() {
    }
    
    /**
     * instantiate the class with the JFrame
     */

	public void createJFrame(String[][] map) throws Exception {
    	window = new ViewJFrame(map);
    	window.setVisible(true);
	}
	
	
	public Point getDirection() {
		return window.getDirection();
	}
	
	public void setDirection() {
		window.setDirection();
	}
	
	public Boolean getSpell() {
		return window.getSpell();
	}
	
	public void setSpell() {
		window.setSpell();
	}
	
	public void setScore(int score) {
		window.getJPanel().setScore(score);;
	}
	
	public void lose() {
		window.getJPanel().lose();
	}
	
	public void setMap(IElement[][] map) {
		window.getJPanel().changes(map);
	}
	



    
 
    
    

}
