package practice;

public class Antelope extends Mammal implements WalksOn4Legs {
	public boolean isWalking(){
		System.out.println("Antelope is walking");
		return true;
	}
	
	// This is the simplest implementation of abstract parent method
//	Long getOffsprings() {
//		return (long) numberOfOffspring;
//	}
	
	// This implementation uses a less restrictive access modifier - protected vs. default
	protected Long getOffsprings(){
		return (long) numberOfOffspring;
	}
	
	// This won't compile because we cannot reduce visibility of inherited method
//	private Long getOffsprings(){
//		return (long) numberOfOffspring;
//	}
	
	// This overloaded method won't compile because you can't convert from int to Long
//	public Long getOffsprings(String a){
//		return numberOfOffspring;
//	}
	
}
