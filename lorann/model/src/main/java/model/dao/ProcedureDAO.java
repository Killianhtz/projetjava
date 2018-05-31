package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;
/**
 * <h1>The Class ProcedureDAO.</h1>
 *
 * @author Guillaume PIRES guillaume.pires@cesi.fr
 * @version 1.0
 */
public abstract class ProcedureDAO extends AbstractDAO{


	    /** The sql map by level. */
	    private static String sqlMapByLevel   = "{call FindMapByLevel(?)}";

	    /** The sql example by name. 
	    private static String sqlExampleByName = "{call findExampleByName(?)}";
*/
	    /** The sql all examples. 
	    private static String sqlAllExamples   = "{call findAllExamples()}";
*/
	    /** The Element column index. */

	    private static int    ElementIndex    = 2;

	    /** The X column index. */
	    private static int    XPositionIndex    = 3;

	    /** The Y column index. */
	    private static int    YPositionIndex  = 4;

	    /**
	     * Gets the example by id.
	     *
	     * @param id
	     *            the id
	     * @return the example by id
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
	    /**
	     * Gets the example by name.
	     *
	     * @param name
	     *            the name
	     * @return the example by name
	     * @throws SQLException
	     *             the SQL exception
	     */
	  /* 	public static Example getMapByLevel(final int Level) throws SQLException {
	        final CallableStatement callStatement = prepareCall(sqlMapByLevel);
	        Example procedure = null;
	        callStatement.setInt(1, Level);
	        if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                procedure = new Example(result.getString(ElementIndex),result.getInt(XPositionIndex), result.getInt(YPositionIndex));
	            }
	            result.close();
	        }
	        return procedure;
	    }
	    */
}