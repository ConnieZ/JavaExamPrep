package practice;

// This won't compile because only a nested class
// can be static
// public static class Chicken {
public class Chicken {
	
	private static int NUMBER_CHICKS;
	
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
