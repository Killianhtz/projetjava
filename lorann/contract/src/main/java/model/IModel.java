package model;

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
	
	 void moveUp() throws IOException;
	 void moveDown() throws IOException;
	 void moveLeft() throws IOException;
	 void moveRight() throws IOException;
	 IElement getElementUp() ;

	IElement getElementDown();

	IElement getElementRight();

	IElement getElementLeft();
}
