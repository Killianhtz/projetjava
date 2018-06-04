package model;

import java.awt.Point;
import java.io.IOException;
import java.util.List;

import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;
import model.element.mobile.Behavior;
import model.element.mobile.BehaviorOne;
import model.element.mobile.Demon;
import model.element.mobile.Direction;
import model.element.mobile.Lorann;
//import model.element.mobile.Spell;
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
	
	MotionlessFactory penetrableMotionlessFactory;
	MotionlessFactory blockingMotionlessFactory;
	MotionlessElement motionlessElement;
	
	private IElement[][] element = new IElement[12][20];
	private Map mapI;
	
	public Lorann lorann;
	public Demon demonD;
	public Demon demonX;
	public Point demonPoint;
	public Direction[] dirDemon;
	
	
	
	
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
		
		mapI = new Map();	
		element = mapI.constructTheMap(map);
		lorann = mapI.getLorann();
		demonD = mapI.getDemonD();
		demonX = mapI.getDemonX();
		view.setMap(element);
		  
	}
	
	
	
	public void changeTheMap(IMobile mobile) throws IOException  {
		
		element = mapI.changeTheMap(mobile);
		element[mobile.getY()][mobile.getX()] = (IElement)mobile;
		view.setMap(element);
	}
	
	
	public void setView(IView view) {
		this.view = view;
	}
	
	public void move(IMobile mobile, Point point) throws IOException{
		mobile.move(point);
		changeTheMap(mobile);
	}

	
	public IElement getElement(IMobile mobile, Point point) {
		IElement elementUp = element[mobile.getY() + (int)point.getY()][mobile.getX() + (int)point.getX()];
		return elementUp;
	}
	

	
	public void openGate(IMobile mobile)  throws IOException {
		penetrableMotionlessFactory = new PenetrableMotionlessFactory();
		for (int y = 0; y < 12; y++) {
			for(int x = 0; x < 20; x++) {
				if(element[y][x].getSprite().getConsoleImage() == "S") {
					motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.GATEOPEN);
					element[y][x] = motionlessElement;
				}
				
			}
		}
		changeTheMap(mobile);
	}
	
	public IMobile getLorann() {
		return this.lorann;
	}
	
	public IMobile getDemonDMobile() {
		return this.demonD;
	}
	
	public IMobile getDemonXMobile() throws Exception{
		return this.demonX;
	}
	
	public Point demonBehavior(int a, IMobile mobile) throws IOException {
		dirDemon = mapI.demonD.getDirection();
		
		if(dirDemon[a] == Direction.RIGHT) {
			demonPoint = new Point(1,0);
		}
		else if(dirDemon[a] == Direction.LEFT) {
			demonPoint = new Point(-1,0);
		}
		else if(dirDemon[a] == Direction.UP) {
			demonPoint = new Point(0,-1);
		}
		else if(dirDemon[a] == Direction.DOWN) {
			demonPoint = new Point(0,1);
		}
		return demonPoint;
	}


	

	
}