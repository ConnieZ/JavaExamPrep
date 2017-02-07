package practice;

public class PracticeClass {
	
	// This won't compile because vars can't begin with numbers
	// static int 123;
	
	// This won't compile, because void can't be used in a var declaration
	// but also char is a data type, not var name
	// void char = 'a';
	
	byte b1 = 2;
	int c1$ = b1;
	
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
		this.color = color;
	}
	
	public static String getName(){
		String temp = new String("Jane Doe");
		return temp;
	}
	
	public void noteNewOffspring(Mammal mammal){
		mammal.numberOfOffspring++;
	}
	
	public static void main(String[] args) {
		
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
		
		String result;
		result = getName();
		System.out.println(result);
		// result is a String reference, and it refers to object returned
		// from getName() method by reference, therefore,
		// after result is no longer referring to that object,
		// that object becomes eligible for garbage collection		
		result = null;
		// Calling this method doesn't affect eligibility for garbage collection
		System.gc();
	}

}
