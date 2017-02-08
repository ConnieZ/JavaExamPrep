package practice;

// By default Java will import the used class/interface like this
// import util.Ports;

// This import won't make the code compile, if you use Ports.LEFT_MOTOR
// import static util.Ports.*;

// This imports the static members of Ports interface, so
// they can be referenced without interface name
import static util.Ports.*;

// This will additionally import the Ports interface, so 
// we can use Ports classname with its members.
// Technically this is sufficient and makes the previous import
// redundant
import util.*;

public class PracticeClass {
	
	// This won't compile because vars can't begin with numbers
	// static int 123;
	
	// This won't compile, because void can't be used in a var declaration
	// but also char is a data type, not var name
	// void char = 'a';
	
	private byte b1 = 2;
	private int c1$ = b1;
	
	// This won't compile without casting c1$ to short
	// short s1 = c1$;
	
	long e_2 = c1$;
	
	private String color;
	
	// This is not a constructor, it's a method, returning void
	public void PracticeClass(){
		// Calling the overloading method
		PracticeClass("white");
	}
	
	// This is not a constructor, it's an overloading method
	public void PracticeClass(String color){
		// this will not do anything to the value of color
		// the left-hand side is not qualified
		color = color;
		// this will actually assign the arg color value to 
		// the instance variable
		this.color = color;
		
		int a,b = 1;
		// This line won't compile because the local a var wasn't initialized
		// System.out.println("Color was assigned, with outputs: " + a + ", " + b);
	}
	
	public static String getName(){
		String temp = new String("Jane Doe");
		return temp;
	}
	
	public void noteNewOffspring(Mammal mammal){
		mammal.numberOfOffspring++;
	}
	
	// Method that will be passed a lambda expression
	public static void check(Climb climb, int height){
		if (climb.isTooHigh(height, 4))
			System.out.println("too hight");
		else 
			System.out.println("ok");
	}
	
	// This overrides the Object finalize method with no args
	// it will be called at the time of garbage collection and
	public void finalize(){
		System.out.println("Undergoing garbage collection");
	}
	
	// This method won't be called at the time of garbage collection
	// because it doesn't override the Object finalize method
	// this just overloads the method with no args and won't be used
	public void finalize(Object o){
		System.out.println("Object " + o.toString() + " is undergoing garbage collection");
	}
	
	public static void main(String[] args) {
		
		// using lambdas
		check((h, l) -> h > l, 5);
		
		// Referencing Interface static members (see imports above)
		System.out.println("Motors: " + Ports.RIGHT_MOTOR + ", " + LEFT_MOTOR);
		
		Chicken c = new Chicken();
		c.growChickens();
		
		// This won't compile, because Mammal is an abstract class
		// which you cannot create instances of
		// new PracticeClass().noteNewOffspring(new Mammal());
		
		// This won't compile because String is not a superclass of Mammal
		// new PracticeClass().noteNewOffspring((Mammal) new String());
		
		// Null can always be passed as reference,
		// but it will cause NullPointerException at runtime
		// new PracticeClass().noteNewOffspring(null);
		
		// We use a default constructor to create the instance
		// This doesn't call the PracticeClass method,
		// therefore, the instance var doesn't get initiated,
		// and stays null
		PracticeClass p = new PracticeClass();
		// even though we try to access a private variable,
		// we are still within the same class, so this will compile
		System.out.println("Color: " + p.color);
		p.PracticeClass("Yellow");
		System.out.println("Color assigned: " + p.color);
		
		// This will print sum of two integers, not concatenated value
		System.out.println(p.b1 + p.c1$);
		
		String result;
		result = getName();
		System.out.println(result);
		// result is a String reference, and it refers to object returned
		// from getName() method by reference, therefore,
		// after result is no longer referring to that object,
		// that object becomes eligible for garbage collection		
		result = null;
		
		// the PracticeClass var is assigned to null, which
		// makes the object eligible for garbage collection
		p = null;
		// Calling this method doesn't affect eligibility for garbage collection
		System.gc();
		// At this time the finalize() method will be called
		
	}

}
