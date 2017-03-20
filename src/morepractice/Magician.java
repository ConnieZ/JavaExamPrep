package morepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Magician extends Person {
	
	public int knownTricks;
	
	ArrayList magicianObjects = new ArrayList(); // this will only allow Objects, and any primitives will be autoboxed 
	// - promoted to wrapper classes
	
	public Magician(){
		this(0);
		// same as
		// new Magician(0);
	}
	
	public Magician(int knownTricks){
		super();
		this.knownTricks = knownTricks;
		// if we didn't have this. , the instance variable wouldn't have been used, instead the more granular - parameter would be used
	}
	
	// This private constructor is useful when a class only has static methods or the class wants to control all calls to create
	// new instances of itself.
	private Magician(String caseName){
		System.out.println("This is a private Magician, he investigates clown crimes.");
	}
	
	// This method demos ArrayList functionality
	public void performMagicTrick(){
		
		magicianObjects.add("AlbinoRabbit");  
		magicianObjects.add(Boolean.TRUE); // this adds an object of wrapper class
		// The max index for adding an element is equal to size of array, otherwise, it will throw exception at runtime.
		magicianObjects.add(2, 42);
		magicianObjects.add(Boolean.TRUE); // adding a duplicate works
		System.out.println("Find true: " + magicianObjects.contains(true));
		System.out.println(magicianObjects);
		magicianObjects.add(Integer.parseInt("777")); // the parse method involves autoboxing
		System.out.println(magicianObjects.remove(Integer.valueOf(42))); // proper way to remove int from ArrayList, because valueOf returns wrapper class
		// , no autoboxing involved
		System.out.println(magicianObjects.remove(Integer.valueOf(777)));
		//System.out.println(magicianObjects.remove(42)); // this will attempt to remove the element at index 42 (no autoboxing rules for "remove")
		System.out.println(magicianObjects.remove(true)); // removes only the first match of Boolean object
		System.out.println(magicianObjects.remove("BlackRabbit")); // false (no match found)
		System.out.println(magicianObjects.size());
		magicianObjects.set(0, false); // replacing an existing object with a primitive
		System.out.println(magicianObjects); 
		System.out.println(magicianObjects.remove(false)); // true
		// This will clear out all elements, returning size to 0
		// magicianObjects.clear();
		
		// Contains method calls equals() on every element of array, that allows primitives
		// to be recognized and properly compared
		System.out.println("Find 42: " + magicianObjects.contains(42));
		magicianObjects.add("HornedBunny");
		magicianObjects.remove(true);
		
		// How to convert ArrayList to array
		Object[] objectArray = magicianObjects.toArray();
		System.out.println(objectArray.length); // 1
		// Casting doesn't throw exception only if all objects in ArrayList are in fact Strings
		String[] stringArray = (String[]) magicianObjects.toArray(new String[5]); // initial capacity can be 0
		System.out.println(stringArray.length); // 5, but only first element is filled
		
		// How ArrayList objects are sorted, same method, but different helper class
		magicianObjects.add("69LeggedSpider");
		// This justifies the statement "An array is ordered", because it can be.
		Collections.sort(magicianObjects);
		System.out.println(magicianObjects);

		
		// Converting from an array to a List creates a backed List - array and list are linked
		// When a change is made to one, it is available in the other. 
		// The list is fixed-size, so no new elements can be added, and none can be removed.
		// Think of it like this: "view array a AS LIST", but it's still an array
		// Just that it has more API options: from array and from List (with exceptions)
		List<String> fixedList = Arrays.asList(stringArray);
		//List<String> list = stringArray.asList(); // this doesn't compile, because There is no asList() method on an array instance
		
		// This method also takes vararg as array, same rules apply
		List<Object> fixedList2 = Arrays.asList("HornedBunny","AlbinoRabbit","Dove");
		
		// Remember what a fixed list means
		// fixedList2.remove("Dove"); // Throws java.lang.UnsupportedOperationException	
		
		
		Magician mrGadget = new Magician("Pretty in Pinstriped"); // this private constructor works fine inside Magician class
	}
	
}
