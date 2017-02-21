package morepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaExam {

	public static void main(String[] args) {
		JavaExam j = new JavaExam();
		
		// Won't compile, because you can't create instances of abstract classes
		// Entertainment e = new Entertainment();
		
		// Notice how to create a nested class instance
		Circus c = j.new Circus();
		c.slowTime(5);
		
		// The returned reference can be assigned to Object reference circusFolks
		// Notice how the private method is accessible if declared in a nested class
		Object circusPeeps = c.getCircusMembers();
		
		// This will compile, but throw runtime exception, if the reference points to null
		// e.g. if the array hadn't been initialized
		System.out.println(circusPeeps.getClass());
		
		// create local variable pointing to the instance var of the class 
		String circusFolks[] = c.getCircusMembers();
		c.printCircusMembers(); // prints how the instance var looks before sorting
		
		//Numbers sort before letters and uppercase sorts before lowercase,
		Arrays.sort(circusFolks);
		
		// Notice, how we sorted by reference (the print method prints instance var
		// but we sorted by calling the local var)
		c.printCircusMembers(); // prints how the instance var looks after sorting
		
		// Binary search for element that isn't contained in array will return 
		// a value one smaller than the negative of index where it should be inserted
		// to preserve sorted order
		System.out.println(Arrays.binarySearch(circusFolks, "SpinelessZiggy"));
		// For unsorted arrays, the line will compile but return unpredictable results

		// If you don't qualify the new Circus() , this error will be thrown
//		No enclosing instance of type JavaExam is accessible. Must qualify the 
//		allocation with an enclosing instance of type JavaExam 
//		(e.g. x.new A() where x is an instance of JavaExam).
		Circus c2 = j.new Circus();
		c2.printCircusMembers();
		
		// List is an interface, so you can assign ArrayList object to it, but not vice versa.
		// Generics are optional here, but if you don't specify them, it defaults to Object
		// You can optionally provide initial capacity for the ArrayList, but you don't  have to.
		List<Circus> townCircuses = new ArrayList<>(1);
		// This won't compile, because we declared this to be a String ArrayList only
		//townCircuses.add("InvalidCircus");
		
		// This constructor creates a list containing the elements of the specified 
		// collection, in the order they are returned by the collection's iterator.
		// Notice that it creates a brand new object, not reference to passed object
		ArrayList<Circus> townCircuses2 = new ArrayList<>(townCircuses);
		
		// Compare two lists
		// to see if they contain the same elements in the same order.
		System.out.println("Both arrayLists are the same?: " + townCircuses2.equals(townCircuses));
		
		// Add an object to second list
		townCircuses2.add(j.new Circus());
		System.out.println("townCircuses empty? " + townCircuses.isEmpty()); // true
		System.out.println("townCircuses2 empty? " + townCircuses2.isEmpty()); // false
		System.out.println("Both arrayLists are the same?: " + townCircuses2.equals(townCircuses));

		
		String g = "grep";
		String p = g.replace("gr", "2two");
		System.out.println(p);
		String a = new String();
		System.out.println("New String object: " + new String());
		System.out.println(a.replace("", "b"));
		// Character.parseChar("a"); // There is no method parseChar(String s)
		Integer wildNumber = Integer.valueOf(34); // Integer.valueOf takes only int or String. Throws exception if String has letters and punctuation
		System.out.println(wildNumber);
		
		System.out.println(Boolean.valueOf("True"));

		
		ArrayList magicianObjects = new ArrayList(); // this will only allow Objects, and any primitives will be autoboxed - promoted to wrapper classes
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
		

		
	}

	
	// Default-access class extending private abstract class is possible 
	// because both are nested classes
	class Circus extends Entertainment {
		
		String [] circusMembers = new String[] {"SpookyFace", "MadEye", "SharpTooth", "3EyeJackie"};
		
		int[] trick [], bigTrick [][]; // a 2 dimensional AND a 3 dimensional array
		int[][] uglyTrick = {{1, 4}, {3}, {9,8,7}}; // array with different sizes of elements
		
		int [][] superUglyTrick = new int[4][]; // array with different sizes of elements
		{		
			// you cannot initialize an array after declaration outside a method
			// it's because this counts as statement, and only declarations pass outside methods.
			// but inside an initializer block, this passes ok
			superUglyTrick[0] = new int[5];
			superUglyTrick[1] = new int[3];
		}
		
		// You have to implement all inherited methods from abstract classes and interfaces
		// Otherwise the code won't compile
		
		// implementing inherited implicitly public method from interface
		// method signature should be same, including return type and arguments
		public void bore() {
			
		}
		
		// This is an overloaded method
		public void bore(Person p){};
		
		// Making inherited method less restrictive is allowed
		@Override
		protected void slowTime() {
			
		}
		
		// This won't compile because abstract methods can only be in abstract classes and interfaces
		// abstract void travel();
		
		private String[] getCircusMembers(){
			return circusMembers;
		}
		
		private void printCircusMembers(){
			for(String m : circusMembers){
				System.out.println(m);
			}
		}
		
	}
	
	private abstract class Entertainment implements CanBore{
		// abstract class doesn't actually have to implement an interface method
		// but this won't compile because we are trying to reduce visibility of implicitly public method 
		// abstract void bore();
		
		public abstract void bore(); // this is unnecessary, because no body is provided
		
		// default access method
		abstract void slowTime();
		
		// abstract classes can have non-abstract methods
		void slowTime(int minutes){}
		
	}
	private interface CanBore {
		String VALUE = "st";
		// Illegal modifier for the interface method bore; only public, abstract, default, static
		// and strictfp are permitted
		// private void bore();
		
		void bore(); // implicitly public
		
	}


}