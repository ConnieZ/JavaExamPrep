package methodspractice;

public class MutableClass {
	// encapsulated property
	private StringBuilder fakeDiamond;
	
	public MutableClass(StringBuilder initValue){
		// unfortunately, we point the private property to the object referenced by initValue
		fakeDiamond = initValue;		
	}
	
	public StringBuilder getFakeDiamond(){
		// we return reference to the private property
		return fakeDiamond;
	}
}
