package controller;

import java.awt.Point;
import java.io.IOException;

import model.IModel;
import view.IView;

public class CastingSpell {
	private IModel model;
	private IView view;
	private Event event;
	
	public CastingSpell(IView view,IModel model, Event event) {
        this.view = view;
		this.model = model;	
		this.event = event;
	}
	
	
	
	public void createSpell(Point lastDirection) throws IOException {
		System.out.println(lastDirection);
		model.creatSpell(lastDirection);
	}
}
