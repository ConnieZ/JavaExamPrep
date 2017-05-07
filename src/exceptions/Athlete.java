package exceptions;

class LargeBall extends Exception {}; 
class LargerBall extends Exception {};
class SmallBall extends LargeBall {}; 

public class Athlete {
	public static void throwBall() throws LargeBall {} // Athletes are born to throw LargeBalls

}

class Jessy extends Athlete {
	
	public static void throwBall() throws SmallBall {} // Athletes can throw Balls they were born to throw or smaller Balls
	//, but not larger Balls or other Balls (other checked exceptions)
	
	//public static void throwBall() throws LargeBall {} //compiles but counts as duplicate method
	
	// public static void throwBall() throws LargerBall {} // doesn't compile, Athletes cannot throw Balls larger than what they
	// were born to throw (parents of exceptions declared in parent method)
}

class Disabled extends Athlete{
	public static void throwBall() {} // disabled Athletes are those that don't throw any Balls (Exceptions)
	// even though they were born to throw Large Balls
}

class Boxer extends Athlete{
	public static void throwBall() throws GoodFighter{} // Boxer Athletes throw Fighters (unchecked exceptions)
	// but don't throw any Balls, even though they were born to
}
