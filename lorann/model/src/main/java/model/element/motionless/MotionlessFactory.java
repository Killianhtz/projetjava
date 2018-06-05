package model.element.motionless;

import java.io.IOException;

/**
 * Abstract superclass, part of the DP factory.
 */
public abstract class MotionlessFactory {

		/**
		 * Abstract method used to create motionless elements
		 */
		public abstract MotionlessElement createElement(TypeMotionless type) throws IOException; 
		
}
