package practice;

// By default Java will import the used class/interface like this
// import util.Ports;

// This import won't make the code compile, if you use Ports.LEFT_MOTOR
// import static util.Ports.*;

// This imports the static members of Ports interface, so
// they can be referenced without interface name
import static util.Ports.*;
//This will additionally import the Ports interface, so 
//we can use Ports classname with its members.
//Technically this is sufficient and makes the previous import
//redundant
import util.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
	
	// this creates a two-layer array, both layers are assigned capacity
	// use property length to access the length of the array
	int[] times[] = new int[3][3];
	
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
			System.out.println("too high");
		else 
			System.out.println("ok");
	}
	
	// Another method that will be passed a lambda expression
	// The method has no parameters in this case, observe syntax
	public static void caller(WalksOn4Legs w, int i){
		
		// Pay attention, because the if block is inside for loop
		// the code with continue and break will compile
		// However, if you remove the for loop, the code will not compile
		for(int k = 0; k <= i; k++){
			if(w.isWalking()){
				System.out.println("Animal is walking");
				continue;
			}else{
				// code after this line in for loop is unreachable, and won't compile
				break;
			}
		}
		System.out.println("Animal stopped walking");
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
	
	
	/**
	 * The famous main method, pay attention to how it's declared
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// using lambdas
		check((h, l) -> h > l, 5);
		
		// using a lambda for a method with no parameters
		// always make sure there's a parameter list and a returned value
		caller(() -> true, 2);
		
		// Referencing Interface static members (see imports above)
		System.out.println("Motors: " + Ports.RIGHT_MOTOR + ", " + LEFT_MOTOR);
		
		Chicken c = new Chicken();
		c.growChickens();
		
		// This won't compile, because Mammal is an abstract class
		// which you cannot create instances of
		// new PracticeClass().noteNewOffspring(new Mammal());
		
		// This won't compile because String is not a superclass of Mammal
		// new PracticeClass().noteNewOffspring((Mammal) new String());
		
		// We create a single object of type Antelope, but it will be referenced by
		// different types of references
		Mammal antelope = new Antelope();
		// This compiles because WalksOn4Legs is a subclass of Object
		WalksOn4Legs walksOn4Legs = (WalksOn4Legs) antelope;
		WearsHorns wearsHorns = (WearsHorns) walksOn4Legs;
		// The casts compile and succeed because Antelope implements these interfaces.
		System.out.println(walksOn4Legs.isWalking());
		System.out.println(wearsHorns.getNumberOfHorns());
		
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
		
		// This won't compile, because that's not a correct way of accessing
		// array elements
		// int arrElement = p.times[2,5];
		
		// This will compile but throw a ArrayOutOfBoundsException at runtime
		// int arrElement = p.times[2][5];
		
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
		
		// The line of code won't compile with just 2 args
		LocalDate d = LocalDate.of(2015, 5, 1);
		Period period = Period.of(1, 2, 3);
		d = d.minus(period);
		// LocalTime, LocalDate, Period, etc. need an import of java.time package
		LocalTime lt = LocalTime.of(17, 30, 20);
	    LocalDateTime ldt = LocalDateTime.of(d, lt);
	    // DateTimeFormatter will only work with a LocalDateTime object
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		// This line throws an exception, if you try to 
		// use DateTimeFormatter with just LocalDate
		 System.out.println(f.format(ldt));
	}

}
