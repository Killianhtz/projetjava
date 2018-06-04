package model;

import java.io.IOException;

public interface IMap {
	
	public IElement[][] constructTheMap(String[][] map) throws IOException;
	public IElement[][] changeTheMap(IMobile mobile) throws IOException;
	
}
