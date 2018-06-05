package model.element.mobile;


public class BehaviorThree implements Behavior {
 
	private Direction[] behave = new Direction[4];
	
	public BehaviorThree() {
		behave[0] = Direction.UP;
		behave[1] = Direction.DOWN;
		behave[2] = Direction.LEFT;
		behave[3] = Direction.RIGHT;
	}
	
	public Direction[] getBehave() {
		return behave;
	}

}
