package methodspractice;

// example of an immutable class, where properties are truly immutable
public class ImmutableClass {
	// encapsulated property
	private StringBuilder diamond;
	
	
	public ImmutableClass(StringBuilder initValue){
		// because we don't just do this
		// diamond = initValue;
		// we don't point the private property to the object referenced by initValue
		diamond = new StringBuilder(initValue);
		// instead we created a new object with building blocks of initValue
	}
	
	public StringBuilder getDiamond(){
		// instead of just returning diamond, and thus returning reference to the private property
		// we create a new object with the building blocks of diamond
		return new StringBuilder(diamond);
		// or we could return an immutable type
		// return diamond.toString(); 
	}
}
