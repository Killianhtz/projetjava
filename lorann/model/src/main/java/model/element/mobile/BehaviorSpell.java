package model.element.mobile;

import java.util.ArrayList;
import java.util.List;

public class BehaviorSpell implements Behavior {
		 
		private List<Direction> behave;
		
		public BehaviorSpell(Direction direction) {
			behave = new ArrayList<Direction>();
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
			behave.add(direction);
		}
		
		public List<Direction> getBehave() {
			return behave;
		}

}
