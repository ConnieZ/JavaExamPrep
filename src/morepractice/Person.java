package morepractice;

import java.time.LocalDate;

public class Person {
	public String name = "Person";
	protected LocalDate dateOfBirth;
	public boolean female = false;
	String homeTown = "Springfield";
	public static int numPeople = 0;
	
	public String toString(){
		return name;
	}
	
	public boolean isFemale(){
		return female;
	}
	
	public Person(){
		numPeople++;
	}
	public Person(String name, boolean isFemale){
		this.name = name;
		this.female = isFemale;
		numPeople++;

	}
	Person(String name, boolean isFemale, LocalDate dob){
		this.name = name;
		this.female = isFemale;
		this.dateOfBirth = dob;
		numPeople++;

	}
}
