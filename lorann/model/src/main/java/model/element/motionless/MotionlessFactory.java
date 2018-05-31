package model.element.motionless;

import java.io.IOException;

public abstract class MotionlessFactory {

		public abstract MotionlessElement createElement(TypeMotionless type) throws IOException; 
		
}
