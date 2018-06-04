package model.element.mobile;

import java.util.ArrayList;
import java.util.List;

public class BehaviorOne implements Behavior {
 
	private List<Direction> behave;
	
	public BehaviorOne() {
		behave = new ArrayList<Direction>();
		behave.add(Direction.RIGHT);
		behave.add(Direction.RIGHT);
		behave.add(Direction.RIGHT);
		behave.add(Direction.LEFT);
		behave.add(Direction.LEFT);
		behave.add(Direction.LEFT);
	}
	
	public List<Direction> getBehave() {
		return behave;
	}

}
