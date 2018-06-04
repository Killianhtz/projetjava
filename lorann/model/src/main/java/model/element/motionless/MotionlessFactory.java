package model.element.motionless;

import java.io.IOException;

public abstract class MotionlessFactory {

		/**
		 * Abstract superclass, part of the DP factory.
		 * @param type
		 * @return
		 * @throws IOException
		 */
		public abstract MotionlessElement createElement(TypeMotionless type) throws IOException; 
		
}
