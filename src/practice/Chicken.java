package practice;

public class Chicken {
	private void layEggs(int... eggs){
		System.out.print("many " + eggs[0] + " ");
	}
	
	private void layEggs(int eggs){
		System.out.print("one " + eggs + " ");
	}
	
	public void growChickens(){
		Chicken c = new Chicken();
		// Java will try to use the more specific method signature first
		// if it doesn't fit the arguments, then the others are attempted
		c.layEggs(1,2);
		c.layEggs(3);
		// This one uses autoboxing
		c.layEggs(new Integer(2));
	}
}
