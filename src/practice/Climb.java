package practice;

interface Climb {
	// this method follows JavaBean naming convention
	// for boolean-returning methods
	boolean isTooHigh(int height, int limit);
	// This interface was created with one method
	// so I can practice using lambdas
	
	// If you try to add more methods, you will encounter
	// issues using lambdas, only one method is allowed
	// boolean isWindStrong(int speed, int direction);
}
