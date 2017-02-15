package practice;

public class Antelope extends Mammal implements WalksOn4Legs, WearsHorns {
	
	public Antelope(String name){
		// if present, this() or super() has to be the first statement in a constructor
		// and the class must have a no-arg constructor defined (default doesn't apply if this constructor is defined)
		this();
		System.out.println("Antelope " + name + " was born!");
	}
	
	public Antelope(){
		
	}
	
	// Inhereted from interface
	public boolean isWalking(){
		
		StringBuilder status = new StringBuilder('c');
		// StringBuilder object can be instantiated with no args, with int arg - setting capacity
		// and with a CharSequence classes, like String, that implement that interface
		// 'c' is actually interpreted as an int value that sets initial capacity
		
		StringBuilder status2 = status.append("Status: ");
		// Apparently, StringBuilder doesn't implement equals() method, so this will return false;
		status.equals("Status: ");
		// This returns false because a non-compile time String object cannot reference the same object as on string pool
		boolean compare = status.toString() == "Status: ";
		// This won't compile because StringBuilder and String cannot be compared like this
		// compare = status == "Status: ";
		compare = status.equals("Status: ");
		
		// Unrelatedly
		String a = "Some String";
		String b = "Some String";
		// Returns true, because a and b refer to the same String object on the String pool
		compare = a == b;
		
		// Notice that substring for StringBuilder still returns a new String object and doesn't modify the StringBuilder object
		String sub = status.substring(1,4);
		// Notice how insert places the string at a position that doesn't exist
		status.delete(6,8).insert(6, ": ");

		// Notice how status2 and status in fact point to the same object, which keeps being modified.
		status.replace(0, 8, "Current Status: ");
		status2.delete(0, 8);
		// This will return true, because the vars point to the same StringBuilder object
		compare = status == status2;
		
		System.out.println(status.append("Antelope is walking"));
		return true;
	}
	
	// Inhereted from interface
	public int getNumberOfHorns(){
		return 2;
	}
	
	// This is the simplest implementation of abstract parent method
//	Long getOffsprings() {
//		return (long) numberOfOffspring;
//	}
	
	// This implementation uses a less restrictive access modifier - protected vs. default
	protected Long getOffsprings(){
		return (long) numberOfOffspring;
	
	}	
	// This won't compile because we cannot reduce visibility of inherited method
//	private Long getOffsprings(){
//		return (long) numberOfOffspring;
//	}
	
	// This overloaded method won't compile because you can't convert from int to Long
//	public Long getOffsprings(String a){
//		return numberOfOffspring;
//	}
	
	public void getEatenByLion(){
		System.out.println("Antelope was devoured.");
	}
	
}
