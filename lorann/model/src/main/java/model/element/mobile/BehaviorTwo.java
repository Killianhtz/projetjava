package model.element.mobile;


public class BehaviorTwo implements Behavior {
 
	private Direction[] behave = new Direction[6];
	
	public BehaviorTwo() {
		behave[0] = Direction.UP;
		behave[1] = Direction.UP;
		behave[2] = Direction.UP;
		behave[3] = Direction.DOWN;
		behave[4] = Direction.DOWN;
		behave[5] = Direction.DOWN;
	}
	
	public Direction[] getBehave() {
		return behave;
	}

}
