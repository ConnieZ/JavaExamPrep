package exceptions;


public class NonAthlete {
	public static void walk(){} // NonAthletes are not born to throw any Balls or throw Fighters
}

class Ashley extends NonAthlete{
	//public static void walk() throws SmallBall {} // NonAthletes cannot throw Balls (checked Exceptions)
	public static void walk() {}
}

class Hermione extends NonAthlete{
	public static void walk() throws GoodFighter{} // NonAthletes, can become Magicians and throw Fighters (unchecked exceptions)
}