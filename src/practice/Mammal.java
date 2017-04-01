package practice;

public abstract class Mammal {
	
	public int numberOfOffspring;
	
	// This demos how a default abstract method should be treated by child classes
	abstract Long getOffsprings();
	
	// There must be a constructor with no arguments in parent class  for super() call in
	// child classes to compile. Somehow Antelope(String name) compiles with this() call, but Antelope() doesn't
	public Mammal(){
		System.out.println("Parent constructor with no arguments is called");
		// new Antelope(); this compiles but causes infinite loop, program fails
	}

}
