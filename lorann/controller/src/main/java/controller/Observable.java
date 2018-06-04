package controller;

import java.util.Observer;

public interface Observable {
	public void notifyObserver();
	public void addObserver(Observer o);
}
