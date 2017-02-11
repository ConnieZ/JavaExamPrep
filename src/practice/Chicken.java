package practice;

import java.util.*;

// This won't compile because only a nested class
// can be static
// public static class Chicken {
public class Chicken {
	
	private static int NUMBER_CHICKS;
	public List chickens = new ArrayList();
	
	public Chicken(){
		NUMBER_CHICKS++;
	}
	
	private void layEggs(int... eggs){
		System.out.print("many " + eggs[0] + " ");
	}
	
	private void layEggs(int eggs){
		System.out.print("one " + eggs + " ");
	}
	
	public void growChickens(){
		// A non-static method like this can reference
		// other non-static members without an object instance
		// However, if it were a static method, it would need an instance
		// to call those methods
		
		// Java will try to use the more specific method signature first
		// if it doesn't fit the arguments, then the others are attempted
		layEggs(1,2);
		layEggs(3);
		// This one uses autoboxing
		layEggs(new Integer(2));
		
		Chick ch = new Chick();
		
		chickens.add("Little Chick");
		// add(int) method will use autoboxing (new Integer()) to create an object and add it to List
		chickens.add(2);
		chickens.add(ch);
		// same autoboxing rule
		chickens.add(false);
		// remove(int) doesn't use autoboxing, because it's easier to use the int as index of position, so
		// ch will actually be removed at position 2
		chickens.remove(2);
		// returns true, because primitive was autoboxed and we can refer to it by its wrapper class
		chickens.contains(new Boolean(false));
		chickens.contains(2);
	}
	
	// This is an inner class, it can be static
	// Only a nested class can be static
	public static class Chick{
		// A static nested class has access to only static members
		// of the outer class
		int rank = NUMBER_CHICKS;
		{
			System.out.println("Count chicks: " + rank);
		}
	}
}
