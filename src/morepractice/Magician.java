package morepractice;

import java.util.ArrayList;

public class Magician extends Person {
	
	ArrayList magicianObjects = new ArrayList(); // this will only allow Objects, and any primitives will be autoboxed - promoted to wrapper classes
	
	// This method demos ArrayList functionality
	public void performMagicTrick(){
		
		magicianObjects.add("AlbinoRabbit");  
		magicianObjects.add(Boolean.TRUE); // this adds an object of wrapper class
		// The max index for adding an element is equal to size of array, otherwise, it will throw exception at runtime.
		magicianObjects.add(2, 42);
		magicianObjects.add(Boolean.TRUE); // adding a duplicate works
		System.out.println("Find true: " + magicianObjects.contains(true));
		System.out.println(magicianObjects);
		System.out.println(magicianObjects.remove(Integer.valueOf(42))); // proper way to remove int from ArrayList, because valueOf returns wrapper class
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
		
	}
	
}
