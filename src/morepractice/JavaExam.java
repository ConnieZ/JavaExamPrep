package morepractice;

public class JavaExam {

	public static void main(String[] args) {
		JavaExam j = new JavaExam();
		
		// Won't compile, because you can't create instances of abstract classes
		// Entertainment e = new Entertainment();
		
		Circus c = j.new Circus();
		c.slowTime(5);
		
		String g = "grep";
		String p = g.replace("gr", "2two");
		System.out.println(p);
		String a = new String();
		System.out.println(new String());
		System.out.println(a.replace("", "b"));
	}

	
	// Default-access class extending private abstract class is possible 
	// because both are nested classes
	class Circus extends Entertainment {
		
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
