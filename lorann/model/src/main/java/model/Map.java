package model;

import java.io.IOException;
import model.IElement;
import model.element.mobile.BehaviorOne;
import model.element.mobile.BehaviorThree;
import model.element.mobile.BehaviorTwo;
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
	private Lorann lorann;
	private Demon[] demon;
	private Boolean isThereDemonX = false;
	private Boolean isThereDemonD = false;
	private Boolean isThereDemonZ = false;
	private Boolean isThereDemonF = false;
	
	
	MotionlessFactory penetrableMotionlessFactory;
	MotionlessFactory blockingMotionlessFactory;
	MotionlessElement motionlessElement;
	
	public Map() {	
	}
	
	public IElement[][] constructTheMap(String[][] map) throws IOException {
		this.mapSave = map;
		penetrableMotionlessFactory = new PenetrableMotionlessFactory();
		blockingMotionlessFactory = new BlockingMotionlessFactory();
		demon = new Demon[4];
		
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
						lorann = new Lorann(0);
						element[y][x] = lorann;
						lorann.setPosition(x, y);
						break;
					case "D":
						demon[0] = new Demon(new BehaviorOne(),0);
						element[y][x] = demon[0];
						demon[0].setPosition(x, y);
						isThereDemonD = true;
						break;
					case "X":
						demon[1] = new Demon(new BehaviorTwo(),1);
						element[y][x] = demon[1];
						demon[1].setPosition(x, y);
						isThereDemonX = true;
						break;
					case "Z":
						demon[2] = new Demon(new BehaviorThree(),2);
						element[y][x] = demon[2];
						demon[2].setPosition(x, y);
						isThereDemonZ = true;
						break;
					case "F":
						demon[3] = new Demon(new BehaviorThree(),3);
						element[y][x] = demon[3];
						demon[3].setPosition(x, y);
						isThereDemonF = true;
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
	
	public Demon getDemonD() {
		return this.demon[0];
	}
	public Demon getDemonX() {
		return this.demon[1];
	}
	public Demon getDemonZ() {
		return this.demon[2];
	}
	public Demon getDemonF() {
		return this.demon[3];
	}
	
	public Boolean getIsThereDemonX() {
		return this.isThereDemonX;
	}
	
	public Boolean getIsThereDemonD() {
		return this.isThereDemonD;
	}
	
	public Boolean getIsThereDemonZ() {
		return this.isThereDemonZ;
	}
	
	public Boolean getIsThereDemonF() {
		return this.isThereDemonF;
	}
	
	public void setDemonDownD(Boolean a) {
		this.isThereDemonD = a;
	}
	public void setDemonDownX(Boolean b) {
		this.isThereDemonX = b;
	}
	
	public void setDemonDownZ(Boolean a) {
		this.isThereDemonZ = a;
	}
	public void setDemonDownF(Boolean b) {
		this.isThereDemonF = b;
	}
	
	
}
