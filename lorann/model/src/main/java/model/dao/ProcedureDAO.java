package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Example;


public abstract class ProcedureDAO extends AbstractDAO{


	    /** The sql map by level. */
	    private static String sqlMapByLevel   = "{call FindMapByLevel(?)}";

	    /** The Element column index. */

	    private static int    ElementIndex    = 2;

	    /** The X column index. */
	    private static int    XPositionIndex    = 3;

	    /** The Y column index. */
	    private static int    YPositionIndex  = 4;

	    /**
	     * Gets the map by level.
	     *
	     *            the level
	     * @return the map by level
	     * @throws Exception 
	     */

	    public static List<Example> getMapByLevel(final int Level) throws Exception {
	        final ArrayList<Example> procedure = new ArrayList<Example>();
	        final CallableStatement callStatement = prepareCall(sqlMapByLevel);
	        callStatement.setInt(1, Level);
	        if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();

	            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
	                procedure.add(new Example(result.getString(ElementIndex),result.getInt(XPositionIndex), result.getInt(YPositionIndex)));
	            }
	            result.close();
	        }
	        return procedure;
	    }
}