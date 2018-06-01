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
	
	public void constructTheMap(String[][] map) throws IOException;
	
	public void moveUp() throws IOException;
	public void moveDown() throws IOException;
	public void moveLeft() throws IOException;
	public void moveRight() throws IOException;
}
