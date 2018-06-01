package model;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;
import model.element.motionless.BlockingMotionlessFactory;
import model.element.motionless.MotionlessElement;
import model.element.motionless.MotionlessFactory;
import model.element.motionless.PenetrableMotionlessFactory;
import model.element.motionless.TypeMotionless;
import view.IView;



/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	private IElement[][] element = new IElement[12][20];
	
	private IView view;
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
        this.connectToDB();
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getMapByLevel(int)
     */
    

    public List<Example> getMapByLevel(final int Level) throws Exception {
        return ProcedureDAO.getMapByLevel(Level);
        
    }

   
    /*Try to Connect to the database lorann */
    public void connectToDB() {
    	LorannBDDConnector conn = null;
    	try {
    		System.out.print("Trying to connect to the Database :\n");
    		conn =new LorannBDDConnector();
    		System.out.print("The connection is established \n");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }

	public void constructTheMap(String[][] map) throws IOException {
		
		for (int y = 0; y < 12; y++) {
			System.out.println("");
			for(int x = 0; x < 20; x++) {
				
				System.out.print(map[y][x]);
				  
			}
			
		}
		
		MotionlessFactory penetrableMotionlessFactory = new PenetrableMotionlessFactory();
		MotionlessFactory blockingMotionlessFactory = new BlockingMotionlessFactory();
		
		MotionlessElement motionlessElement;
		
		for (int y = 0; y < 12; y++) {
			for(int x = 0; x < 20; x++) {
				switch(map[y][x]) {
					case "V":
						motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.VOID);
						element[y][x] = motionlessElement;
						break;
					case "S":
						motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.GATECLOSE);
						element[y][x] = motionlessElement;
						break;
					case "O":
						motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.BONE);
						element[y][x] = motionlessElement;
						break;
					case "P":
						motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.HORIZONTALBONE);
						element[y][x] = motionlessElement;
						break;
					case "H":
						motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.VERTICALBONE);
						element[y][x] = motionlessElement;
						break;
					default:
						motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.VOID);
						element[y][x] = motionlessElement;
						break;
					
					
				}

				
				  
			}
			
		}

		view.setMap(element);
		  
	}
	
	public void setView(IView view) {
		this.view = view;
	}
//
	
}