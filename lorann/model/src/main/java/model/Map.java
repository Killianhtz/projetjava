package model;

import java.io.IOException;
import model.IElement;
import model.element.mobile.BehaviorOne;
import model.element.mobile.Demon;
import model.element.mobile.Lorann;
import model.element.motionless.BlockingMotionlessFactory;
import model.element.motionless.MotionlessElement;
import model.element.motionless.MotionlessFactory;
import model.element.motionless.PenetrableMotionlessFactory;
import model.element.motionless.TypeMotionless;

public class Map implements IMap{
	
	private IElement[][] element = new IElement[12][20];
	private String mapSave[][];
	public Lorann lorann;
	public Demon demonD;
	public Demon demonX;
	
	
	MotionlessFactory penetrableMotionlessFactory;
	MotionlessFactory blockingMotionlessFactory;
	MotionlessElement motionlessElement;
	
	public Map() {	
	}
	
	public IElement[][] constructTheMap(String[][] map) throws IOException {
		this.mapSave = map;
		penetrableMotionlessFactory = new PenetrableMotionlessFactory();
		blockingMotionlessFactory = new BlockingMotionlessFactory();
		
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
						demonD = new Demon(new BehaviorOne());
						element[y][x] = demonD;
						demonD.setPosition(x, y);
						break;
					/*case "X":
						demonX = new DemonX();
						element[y][x] = demonX;
						demonX.setPosition(x, y);
						isThereDemonX = true;
						break;*/
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
		return element; 
	}
	
public IElement[][] changeTheMap(IMobile mobile) throws IOException  {
		
		switch(mapSave[mobile.getOldY()][mobile.getOldX()]) {
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
		return element;
	}
	
	public Lorann getLorann() {
		return this.lorann;
	}
	
	public Demon getDemon() {
		return this.demonD;
	}
}
