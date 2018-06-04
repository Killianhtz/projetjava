package model;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;
import model.element.mobile.DemonD;
import model.element.mobile.DemonX;
import model.element.mobile.Direction;
import model.element.mobile.Lorann;
import model.element.mobile.Mobile;
import model.element.mobile.Spell;
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
	private String mapSave[][];
	
	public Lorann lorann;
	public DemonD demonD;
	public DemonX demonX;
	public Spell spell;
	
	public Boolean isThereDemonX = false;
	
	
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
		
		this.mapSave = map;
		penetrableMotionlessFactory = new PenetrableMotionlessFactory();
		blockingMotionlessFactory = new BlockingMotionlessFactory();
		spell = new Spell();
		
		
		
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
					case "L":
						lorann = new Lorann();
						element[y][x] = lorann;
						lorann.setPosition(x, y);
						break;
					case "D":
						demonD = new DemonD();
						element[y][x] = demonD;
						demonD.setPosition(x, y);
						break;
					case "X":
						demonX = new DemonX();
						element[y][x] = demonX;
						demonX.setPosition(x, y);
						isThereDemonX = true;
						break;
					case "E":
						motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.CRYSTALBALL);
						element[y][x] = motionlessElement;
						break;
					case "B":
						motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.PURSE);
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
	
	
	
	public void changeTheMap(IMobile mobile) throws IOException  {
		
		switch(mapSave[mobile.getOldY()][mobile.getOldX()]) {
		case "V":
			motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.VOID);
			element[mobile.getOldY()][mobile.getOldX()] = motionlessElement;
			break;
		case "S":
			motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.GATECLOSE);
			element[mobile.getOldY()][mobile.getOldX()] = motionlessElement;
			break;
		case "O":
			motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.BONE);
			element[mobile.getOldY()][mobile.getOldX()] = motionlessElement;
			break;
		case "P":
			motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.HORIZONTALBONE);
			element[mobile.getOldY()][mobile.getOldX()] = motionlessElement;
			break;
		case "H":
			motionlessElement = blockingMotionlessFactory.createElement(TypeMotionless.VERTICALBONE);
			element[mobile.getOldY()][mobile.getOldX()] = motionlessElement;
			break;
		default:
			motionlessElement = penetrableMotionlessFactory.createElement(TypeMotionless.VOID);
			element[mobile.getOldY()][mobile.getOldX()] = motionlessElement;
			break;
		}

		element[mobile.getY()][mobile.getX()] = (IElement)mobile;
		view.setMap(element);
	}
	
	
	public void setView(IView view) {
		this.view = view;
	}
	
	public void moveUp(IMobile mobile) throws IOException{
		mobile.moveUp();
		changeTheMap(mobile);
	}
//	
	public void moveDown(IMobile mobile) throws IOException {
		mobile.moveDown();
		changeTheMap(mobile);
	}
	
	public void moveRight(IMobile mobile) throws IOException {
		mobile.moveRight();
		changeTheMap(mobile);
	}
	
	public void moveLeft(IMobile mobile)  throws IOException{
		mobile.moveLeft();
		changeTheMap(mobile);
	}
	
	public IElement getElementUp(IMobile mobile) {
		IElement elementUp = element[mobile.getY() - 1][mobile.getX()];
		return elementUp;
	}
	
	public IElement getElementDown(IMobile mobile) {
		IElement elementDown = element[mobile.getY() + 1][mobile.getX()];
		return elementDown;
	}
	
	public IElement getElementLeft(IMobile mobile) {
		IElement elementLeft = element[mobile.getY()][mobile.getX() - 1];
		return elementLeft;
	}
	
	public IElement getElementRight(IMobile mobile) {
		IElement elementRight = element[mobile.getY()][mobile.getX() + 1];
		return elementRight;
	}
	
	public void openGate(IMobile mobile)  throws IOException {
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
	
	public IMobile getDemonD() {
		return this.demonD;
	}
	
	public IMobile getDemonX() {
		return this.demonX;
	}
	
	public Boolean isThereDemonX() {
		return this.isThereDemonX;
	}
	
	public Boolean spellAlive() {
		return this.spell.isAlive();
	}
	
	
}