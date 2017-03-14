package methodspractice;

import java.util.ArrayList;
import java.util.List;
//Static imports are for importing static members of classes only, and not the classes themselves.
import static java.util.Arrays.asList; // that way you can avoid specifying Arrays. when using asList(), in fact Arrays.asList() won't compile
// import static java.util.Arrays; // DOES NOT COMPILE
// If we created an asList method in our class, Java would give it preference over the imported one

import morepractice.Person;

public class Methodology {
	
	//static final constants are named with all caps
	public static final ArrayList<Integer> METHODS = new ArrayList<>(); // constants must be initialized 
	
	private static final int NUMBER_SECONDS_PER_HOUR; // it ok to postpone initialization until static initializer block
	// Static initializers - a block of code with static keyword 
	// They will be run when the class is first used.
	static {
		int numSecondsPerMinute = 60;
		int numMinutesPerHour = 60;
		NUMBER_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
	}
	
	//	There is a common case to use a static initializer: when you need to initialize a
	//	static field and the code to do so requires more than one line. This often occurs
	//	when you want to initialize a collection like an ArrayList. When you do need to
	//	use a static initializer, put all the static initialization in the same block.
	
	private String cameleon = "Blue";
	public void changeColor(String cameleon){
		// this won't reassign the instance variable to a new value, it only affects the local variable
		cameleon = "Green";
		System.out.println("Inside the method, the cameleon is " + cameleon);
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
	// this is because Java tries to use the most specific parameterlist it can find, and the one with String child is more specific
	// Same applies in case of int and Integer 
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
		
		// Calling a static method from a static method (main) is legal
		packForHoliday(jackie, "shorts", "jacket", "books");
		packForHoliday(alice, new String[] {"sweather", "pijamas", "tablet"}); // passing an array is same as vargargs
		packForHoliday(amy); // if we don't pass vargargs or array, Java creates one of length 0
		// packForHoliday(amy, null); // compiles but throws NullPointerException, because method's body tries to access the null object

		//$ReturnDollars_(); // cannot call a non-static method from a static method (main), need object reference
		
		Methodology m = new Methodology();
		m.changeColor(m.cameleon);
		System.out.println("Cameleon's color is " + m.cameleon);
		m.changeColor(m.cameleons);
		System.out.println("Cameleons array starts with " + m.cameleons[0]);
		
		m = null;
		// This compiles and doesn't throw NullPointerException, because for static methods Java replaces object ref with type of object
		m.packForHoliday(new Person()); 
		System.out.println("NUMBER_SECONDS_PER_HOUR " + NUMBER_SECONDS_PER_HOUR);
		
		METHODS.add(1); // you can actually call methods on the constant, but you can't point that reference to another object
		// METHODS = new ArrayList<>(); doesn't compile
		
		// Java is lazy so chooses the method without autoboxing if it's available
		m.payForHolida(4);
		
	}

}
