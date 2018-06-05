package view;

import java.awt.Point;

import model.IElement;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    
    public Point getDirection();
    
    public Boolean getSpell();
    
    public void setSpell();

    public void setDirection();
    
    public void createJFrame(String[][] map) throws Exception;
    
	public void setMap(IElement[][] element);
	
	public void setScore(int score);
	
	public void lose();
}
