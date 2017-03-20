package util;

public interface Ports {
	// by default all interface variables are public and static
	int RIGHT_MOTOR = 1;
	int LEFT_MOTOR = 2;
	
	// Three ways of declaring and instantiating an array
	int[] h1 = new int[2];
	int [] h2 = new int[] {1,2,3};
	int h3[] = {2,3,4};
	
	// This won't compile in an interface, because all vars need to be final here,
	// and final means initialized
	// int ids[], types;
}
