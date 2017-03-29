package methodspractice;

import java.util.ArrayList;
import java.util.List;
//Static imports are for importing static members of classes only, and not the classes themselves.
import static java.util.Arrays.asList; // that way you can avoid specifying Arrays. when using asList(), in fact Arrays.asList() won't compile
// import static java.util.Arrays; // DOES NOT COMPILE
// If we created an asList method in our class, Java would give it preference over the imported one

import java.time.LocalDate;

import morepractice.Person;

public class Methodology {
	
	// public methodology(){} // this attempt at creating a constructor, doesn't compile, because it doesn't match the name of class
	// and it doesn't have a return type like a regular method would.
	
	//static final constants are named with all caps
	public static final ArrayList<Integer> METHODS = new ArrayList<>(); // constants must be initialized 
	
	private static final int NUMBER_SECONDS_PER_HOUR; // it ok to postpone initialization until static initializer block
	// Static initializers - a block of code with static keyword 
	// They will be run when the class is first "used".
	// That includes running a main() method inside a class, even if it's empty
	static {
		int numSecondsPerMinute = 60;
		int numMinutesPerHour = 60;
		NUMBER_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
		System.out.println("First parent initialization. Second, static variables and initializers");
	}
	
	//	There is a common case to use a static initializer: when you need to initialize a
	//	static field and the code to do so requires more than one line. This often occurs
	//	when you want to initialize a collection like an ArrayList. When you do need to
	//	use a static initializer, put all the static initialization in the same block.
	
	// non-static final variables can also be initialized in a constructor
	private final LocalDate holidayStart;
	
	public Methodology(){
		// initializing a final variable
		holidayStart = LocalDate.of(2017, 2, 25);
		System.out.println("Lastly, constructor");

	}
	
	private String cameleon;
	{cameleon  = "Blue";
	System.out.println("Third, instance variables and initializers");}
	
	public void changeColor(String cameleon){
		// this won't reassign the instance variable to a new value, it only affects the local variable
		cameleon = "Green";
		System.out.println("Inside changeColor method, the cameleon is " + cameleon);
	}
	
	
	private String[] cameleons = new String[]{"Yellow", "Red"};
	// an overloaded method is such because of different type and/or number of parameters
	// but other things can also be changed, e.g. access modifiers, specifiers (like static), return types, and exception lists
	// however they are irrelevant to overloading
	private void changeColor(String[] cameleons){
		// cameleons = new String[]{"Purple"}; // this would not reassign object to the instance array variable
		cameleons[0] = "Purple"; // this, however, does reassign the object that the array element points to
	}
	
	// String walk6(int a) { if (a == 4) return ""; } // Doesn't compile because might not produce return
	
	// When returning a value, it needs to be assignable to the return type
	int getLong() {
		// return 9L; // DOES NOT COMPILE, because you can't assign Long to int, but you can cast it
		return (int) 9L;
	}
	
	// Method names may only contain letters, numbers, $, or _
	String $ReturnDollars_(){
		int v = getLong(); // non-static calling another non-static method is legal, because eventually an object reference will be used
		return "$" + v;
	}
	
	// A vararg parameter must be the last element in a method’s parameter list. 
	// You are only allowed to have one vararg parameter per method.
	public static void packForHoliday(Person child, Object ... things){
		List<Object> bag = new ArrayList<>();
		for(Object thing : things){
			bag.add(thing);
		}
		System.out.println(child.toString() + " is packed for holiday.");
	}
	
	// This attempt at overloading doesn't compile, because essentially varargs is an array.
	// private void packForHoliday(Person child, Object[] things){}  
	
	// this overloading works, because the assumption is that there will always be at least 2 args passed
	// But it also implies that you can call packForHoliday(34), the value will be autoboxed to Integer
	private void packForHoliday(Object child, Object ... things){} // compiler tells you that this method is never used
	// this is because Java tries to use the most specific parameter list it can find, and the one with String child is more specific
	// Same applies in case of int and Integer, if the method with int isn't there, it will autobox to Integer, and if Integer isn't there
	// It will try to use Object. Keep in mind that autoboxing doesn't count as conversion, as in case of int to long.
	public void payForHolida(int amount) { 
		System.out.println("Primitive method is used");
	}
	public void payForHoliday(Integer amount) {
		System.out.println("Wrapper class method is used");
	}
	
	public static void main(String[] args) {
		// Using a class imported from another package
		Person jackie = new Person();
		// Using a public attribute of the imported class
		jackie.name = "Jackie";
		Person alice = new Person();
		alice.name = "Alice";
		Person amy = new Person();
		amy.name = "Amy";
		// System.out.println(amy.dateOfBirth); // accessing a protected member, without extending the class or being in the same package fails.
		// Person ashley = new Person("Ashley", true, LocalDate.of(1998, 2, 2)); // this overloaded constructor is package-specific so not visible here
		// System.out.println(ashley.numPeople); // this compiles even if ashley declaration fails
		
		// Notice, that this statement will not be first output of main. Compiler figured out that we will use 
		// Methodology class (regardless of creating an instance of class, i.e. object, just using methods is enough)
		// This causes the first 2 steps of initialization to happen: 1) Parent initialization, 2) static variables and initializers.
		System.out.println("First printed statement in main.");
				
		// Calling a static method from a static method (main) is legal
		packForHoliday(jackie, "shorts", "jacket", "books");
		packForHoliday(alice, new String[] {"sweather", "pijamas", "tablet"}); // passing an array is same as vargargs
		// packForHoliday(alice, {"sweather", "jeans"}); // doesn't compile because array declaration is wrong
		packForHoliday(amy); // if we don't pass vargargs or array, Java creates one of length 0
		// packForHoliday(amy, null); // compiles but throws NullPointerException, because method's body tries to access the null object
		
		// System.out.println("Leaving hometown: " + amy.homeTown); // homeTown is package-private, so not visible here.
		
		//$ReturnDollars_(); // cannot call a non-static method from a static method (main), need object reference
		
		System.out.println("Demo of order of initialization");
		// Notice, that the first 2 steps already finished, now because we are actually creating an object of Methodology
		// the following occur: 3) instance vars and initializers run, and 4) constructor runs
		Methodology m = new Methodology();
		m.changeColor(m.cameleon);
		System.out.println("Cameleon's color is " + m.cameleon);
		m.changeColor(m.cameleons);
		System.out.println("Cameleons array starts with " + m.cameleons[0]);
		
		// Java is lazy so chooses the method without autoboxing if it's available
		m.payForHoliday(4);
		
		m = null;
		// This compiles and doesn't throw NullPointerException, because for static methods Java replaces object ref with type of object
		m.packForHoliday(new Person()); 
		System.out.println("NUMBER_SECONDS_PER_HOUR " + NUMBER_SECONDS_PER_HOUR);
		
		METHODS.add(1); // you can actually call methods on the constant, but you can't point that reference to another object
		// METHODS = new ArrayList<>(); doesn't compile
		
		// Demonstration of ImmutableClass
		StringBuilder mold = new StringBuilder("initial value");
		ImmutableClass stable = new ImmutableClass(mold);
		StringBuilder newMold = stable.getDiamond().append(" added value");
		System.out.println("Immutable after molding " + stable.getDiamond());
		
		// Demonstration of MutableClass
		MutableClass inStable = new MutableClass(mold);
		StringBuilder newMold2 = inStable.getFakeDiamond().append(" added value");
		System.out.println("Mutable after molding " + inStable.getFakeDiamond());
		System.out.println("Mold after molding " + mold);
		
		
		// Demo of map reduce in Java using lambdas
		Grid g = new Grid();
		g.processReduction();
		g.sortCoordinates(g.coords);
		g.printCoordinates(g.coords);
		
		
		// Demo of lambdas
		LambdaSorority ls = new LambdaSorority();
		
		// We created an overloaded method to process applications, this method 
		// takes a list of applicants and a Predicate type of expression
		ls.processApplications(ls.applicants, p -> p.isFemale());
		
		// this method takes only the Predicate type of expression
		// but the parameter is defined as AcceptableToSorority interface 
		ls.processApplications(p -> p.isFemale());
	}

}
