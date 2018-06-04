package controller;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import model.Example;
import model.IModel;
import view.IView;

public class Event implements Observable{
	
	private IModel model;
	private IView view;
	private int score = 0;
	private int level = 0;
	private Boolean nextLevel = false;
	private ArrayList observer;
	
	public Event(IView view,IModel model) {
        this.view = view;
		this.model = model;	
		observer = new ArrayList();
	}
	
    public void testEventUp(Point direction)throws SQLException, Exception {
    	switch(model.getElement(model.getLorann(), direction).getSprite().getConsoleImage()) {
		case "E":
			model.openGate(model.getLorann());
			break;
		case "M":
			this.level = level + 1;
			notifyObserver();
			break;
		case "B":
			this.score = this.score + 650;
			view.setScore(score);
			break;
		case "D":
			lose();
			break;
		case "X":
			lose();
			break;
	} 	
   }
    
    public void lose() {
    	this.view.lose();
    	while(true) {
    		
    	}
    }
	
 

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observer.add(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i=0;i<observer.size();i++)
        {
                Observer o = (Observer) observer.get(i);
                o.update(null, this);
        }
	}
        
    
	
}
