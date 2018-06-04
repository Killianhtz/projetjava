package model.element.mobile;

import java.util.ArrayList;
import java.util.List;

public class BehaviorOne implements Behavior {
 
	private Direction[] behave = new Direction[6];
	
	public BehaviorOne() {
		behave[0] = Direction.RIGHT;
		behave[1] = Direction.RIGHT;
		behave[2] = Direction.RIGHT;
		behave[3] = Direction.LEFT;
		behave[4] = Direction.LEFT;
		behave[5] = Direction.LEFT;
	}
	
	public Direction[] getBehave() {
		return behave;
	}

}
