package methodspractice;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.math.*;
import java.util.Map;


public class Grid {

    ArrayList<Coord> coords = new ArrayList<>();
    
    {
    	
	    coords.add(new Coord(0,0));
	    coords.add(new Coord(4,5));
	    coords.add(new Coord(-1, -3));
	    coords.add(new Coord(4,5));
    }
    
    // Stream<Coord> s = coords.stream();
    // This reduces the arraylist to one coord with sum of all Y values
    long sum = coords.stream().reduce(new Coord(0,0), (a,b) -> {return new Coord(0,a.y+b.y);}).y;

    // Goal to iterate over arraylist and get Coord with min Y or max Y
    Optional<Coord> min = coords.stream().min((o1,o2) -> Long.compare(o1.x,o2.x));

    // removing duplicates
    //List<Coord> deduped = coords.stream().sorted().distinct().collect(Collectors.toList());
    		
    public static void processReduction(){
    	
    	System.out.println("Sum of Y values: " + new Grid().sum);
    	System.out.println("Min Y of all coordinates: " + new Grid().min.get().y);
    	Grid g = new Grid();
    	System.out.println("Does equals work? " + g.coords.get(1).equals(g.coords.get(3)));
    	//System.out.println("Size of deduped " + g.deduped.size());
    }
    
    
    public static void printCoordinates(ArrayList<Coord> cs){
    	System.out.println("Printing coordinates:");
    	for(Coord c : cs){
    		System.out.println(c.x + ", " + c.y);
    	}
    }
    
    public static ArrayList<Coord> sortCoordinates(ArrayList<Coord> cs){
        Collections.sort(cs, new Comparator<Coord>() {
		    public int compare(Coord c1, Coord c2) {
		    	// sorts the objects based on attribute in ascending order 
		        int d = new Long(c1.x).compareTo(new Long(c2.x));
		        if(d == 0){
		            d = new Long(c1.y).compareTo(new Long(c2.y));
		        }
		        return d;
		    }
		});
		return cs;
    }
}


class Coord {
    public long x;
    public long y;
    
    public long getX(){
    	return x;
    }
    
    public long getY(){
    	return y;
    }
    
    public Coord(long x, long y){
        this.x = x;
        this.y = y;
    }
    
    
    // In order to be able to compare Coord objects using Stream API, 
    // we need to have equals() method overriden
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Coord)) {
            return false;
        }
         
        // typecast o to Coord so that we can compare data members 
        Coord c = (Coord) o;
         
        // Compare the Coord members and return accordingly 
        return Long.compare(x, c.x) == 0
                && Long.compare(y, c.y) == 0;
    }
    
}
