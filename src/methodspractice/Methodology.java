package methodspractice;

import java.util.ArrayList;
import java.util.List;

import morepractice.Person;

public class Methodology {
	
	// String walk6(int a) { if (a == 4) return ""; } // Doesn't compile because might not produce return
	
	// When returning a value, it needs to be assignable to the return type
	int getLong() {
		// return 9L; // DOES NOT COMPILE, because you can't assign Long to int, but you can cast it
		return (int) 9L;
	}
	
	// Method names may only contain letters, numbers, $, or _
	String $ReturnDollars_(){
		return "$20";
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
		
		packForHoliday(jackie, "shorts", "jacket", "books");
		packForHoliday(alice, new String[] {"sweather", "pijamas", "tablet"}); // passing an array is same as vargargs
		packForHoliday(amy); // if we don't pass vargargs or array, Java creates one of length 0
		// packForHoliday(amy, null); // compiles but throws NullPointerException, because method's body tries to access the null object

		Methodology m = new Methodology();
		m = null;
		// This compiles and doesn't throw NullPointerException, because for static methods Java replaces object ref with type of object
		m.packForHoliday(new Person()); 
		
	}

}
