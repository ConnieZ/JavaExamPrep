package methodspractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid {

    ArrayList<Coord> coords = new ArrayList<>();
    
    {
    	
	    coords.add(new Coord(0,0));
	    coords.add(new Coord(4,5));
	    coords.add(new Coord(-1, -3));
	    coords.add(new Coord(4,5));
    }
    
    // Goal to iterate over arraylist and get Coord with min Y or max Y
    Stream<Coord> s = coords.stream();
    int sum = s.reduce(new Coord(0,0), (a,b) -> {return new Coord(0,a.y+b.y);}).y;
    
    Optional<Coord> min = coords.stream().min((o1,o2) -> Integer.compare(o1.x,o2.x));

    // removing duplicates
    List<Coord> deduped = coords.stream().sorted().distinct().collect(Collectors.toList());
    		
    public static void processReduction(){
    	
    	System.out.println(new Grid().sum);
    	System.out.println(new Grid().min.get().y);
    	Grid g = new Grid();
    	System.out.println("Does equals work? " + g.coords.get(1).equals(g.coords.get(3)));
    	System.out.println("Size of deduped " + g.deduped.size());
    }
}


class Coord {
    public int x;
    public int y;
    
    public int getX(){
    	return x;
    }
    
    public int getY(){
    	return y;
    }
    
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
    
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
         
        // Compare the data members and return accordingly 
        return Integer.compare(x, c.x) == 0
                && Integer.compare(y, c.y) == 0;
    }
    
}
