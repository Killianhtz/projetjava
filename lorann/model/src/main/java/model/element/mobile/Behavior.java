package model.element.mobile;

import java.util.List;
import java.util.ArrayList;

public interface Behavior {
	
	List<Direction> directions = new ArrayList<Direction>();
	void moveBehavior();
}

class BehaviorOne implements Behavior {
	
	public void moveBehavior() {
		BehaviorOne.directions.add(Direction.RIGHT);
		BehaviorOne.directions.add(Direction.RIGHT);
		BehaviorOne.directions.add(Direction.RIGHT);
		BehaviorOne.directions.add(Direction.LEFT);
		BehaviorOne.directions.add(Direction.LEFT);
		BehaviorOne.directions.add(Direction.LEFT);
	}
}

class BehaviorTwo implements Behavior {
	
	public void moveBehavior() {
		BehaviorOne.directions.add(Direction.TOP);
		BehaviorOne.directions.add(Direction.TOP);
		BehaviorOne.directions.add(Direction.TOP);
		BehaviorOne.directions.add(Direction.BOTTOM);
		BehaviorOne.directions.add(Direction.BOTTOM);
		BehaviorOne.directions.add(Direction.BOTTOM);
	}
}

class SpellBehavior implements Behavior {
	
	public void moveBehavior() {
		
	}
}