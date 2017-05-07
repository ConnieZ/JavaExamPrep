package exceptions;
class GoodFighter extends NullPointerException {}; 
class BetterFighter extends NullPointerException {};
class WorseFighter extends GoodFighter {}; 


public class Magician {

	public static void fight() throws WorseFighter{} 
	
	public static void main(String [] args){}
}

// children of Magicians without magical powers
class Squib extends Magician {
	//public static void fight() throws SmallBall{} // doesn't compile
	public static void fight() {} // can't fight any Magician
}

class Harry extends Magician {
	public static void fight() throws BetterFighter{} // can throw Fighters that are better than an average Magician
}
