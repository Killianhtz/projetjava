package model;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import view.IView;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    

    /**
     * Gets the example by Level.
     *
     * @param Level
     *            the Level
     * @return the example by Level
     * @throws SQLException
     *             the SQL exception
     * @throws Exception 
     */

	List<Example> getMapByLevel(int Level) throws SQLException, Exception;
	
	void setView(IView view);
	
	 void constructTheMap(String[][] map) throws IOException;
	
	 void move(IMobile mobile, Point point) throws IOException;
	 IElement getElement(IMobile mobile, Point point) ;


	IMobile getLorann();
	
	IMobile getDemonDMobile();
	
	IMobile getDemonXMobile() throws Exception;
	  public Boolean getIsThereDemonX();
	Point demonBehavior(int a, int b, IMobile mobile) throws IOException;
	
	public void setMana(Boolean mana);
	public Boolean hasMana();
	public IMobile getSpell();
	public void disappear(IMobile mobile) throws IOException;
	/*
	IMobile getDemonX();
	
	Boolean isThereDemonX();
	
	Boolean spellAlive();*/
    public void creatSpell( Point lastDirection)throws IOException;
	void openGate(IMobile mobile)throws IOException;

	Boolean getIsThereDemonD();
	public void setDemonDownD(Boolean a);
	public void setDemonDownX(Boolean a);
	
	
}
