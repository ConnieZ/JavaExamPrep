package methodspractice;

import java.util.ArrayList;
import java.util.function.Predicate;

import morepractice.Person;

public class LambdaSorority {
	public static ArrayList<Person> applicants = new ArrayList<>();
	{
		applicants.add(new Person("Stacy", true));
		applicants.add(new Person("Jack", false));
	}
	
	// Having this method along the one below confuses Java, code doesn't compile
	// public static void processApplications(ArrayList<Person> peeps, AcceptableToSorority ats){
	//	
	// }
	
	// Need to import java.util.function for the Predicate class to work
	public static void processApplications(ArrayList<Person> peeps, Predicate<Person> checker){
		System.out.println("Lambdas: processing applications.");
		for(Person p : peeps){
			// For Predicate interface, test is defined as taking an argument and returning a boolean
			if(checker.test(p)){
				System.out.println(p.name + " is accepted");
			} else{
				System.out.println(p.name + " is not accepted");
			}
		}
	}
	
	// We don't have to use a generic Predicate<T> checker, we can actually create a 
	// specific functional interface with one test() method (no body required)
	public static void processApplications(AcceptableToSorority checker){
		System.out.println("Lambdas: processing applications.");
		for(Person p : applicants){
			if(checker.test(p)){
				System.out.println(p.name + " is accepted");
			} else{
				System.out.println(p.name + " is not accepted");
			}
		}
	}
	
	// If we try to overload this method with another predicate type parameter as shown below, 
	// compiler will get confused and not allow us to run
	// Essentially the overloaded method above is the same thing as this in the eyes of the compiler
//	public static void processApplications(Predicate<Person> checker){
//		System.out.println("Lambdas: processing applications.");
//		for(Person p : applicants){
//			if(checker.test(p)){
//				System.out.println(p.name + " is accepted");
//			} else{
//				System.out.println(p.name + " is not accepted");
//			}
//		}
//	}
	
}


// this interface will check the gender of the person 
// and based on that decide whether a person is acceptable to the LambdaSorority

// This is a functional interface - it only has one method
// That would be the old way to use lambdas.
interface AcceptableToSorority{
	public boolean test(Person p);
}

//Now you can use the default Java interface 
