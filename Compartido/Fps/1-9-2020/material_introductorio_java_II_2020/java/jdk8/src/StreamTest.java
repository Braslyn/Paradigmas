/**
  * Simple Demo and benchmark between imperative vs FP paralell iteration based on streams
  @author loriacarlos@gmail.com
  @since 2015 Updated  2020
*/
package eif400fp.demo.iteration;
import java.util.*;
import java.util.stream.*;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
/**
	Some classic Point class
*/
class Point {  
    private int x;  
    private int y; 
    private final double[] length = new double[1000];	
      
    public Point() {  
        this.x = this.y = 0;  
    }  
      
    public Point(int x, int y) {  
        this.x = x;  
        this.y = y;  
    }  
      
    /*
	// Normal translate
	public void translate(int dx, int dy) {  
        this.x += dx;  
        this.y += dy;  
    } 
	*/ 
	
	/*
		Heavy demo translate using slow arithmetic for profiling purposes
	*/
    private void heavyTask(int dx, int dy){
        // Fake heavy computation	
        for ( int i = 0; i < this.length.length; i++ ) {  
            this.length[i] = Math.sqrt(Math.abs(Math.log(Math.pow(this.x - dx, 70) 
                             + Math.pow(this.y - dy, 79))));  
        }
    }
	public void translate( int dx, int dy ) { 
        heavyTask(dx, dy);
        this.x += dx;  
        this.y += dy;  
    }  
}  
public class StreamTest {  
    public static void main(String[] args) { 
		
        long start, end, endCreation; 
        final int OBJECTS = 150000;		
        List<Point> pl = new ArrayList<>(); 

		System.out.printf("*** Testing paralell stream computation (%d Points) ***\n", OBJECTS);
		
          
        // Adding  a lot of points to a list  
        start = System.nanoTime();  
        for (int i = 1, j = i + 1; i <= OBJECTS; i++, j++)  
            pl.add(new Point(i, j));  
        endCreation = System.nanoTime() - start;  
        System.out.println("List creation: "   
                + NANOSECONDS.toMillis(endCreation)/1000 + " seconds.");  
          
        // Iterating, Java 8 the Parallel way ...  
        System.out.println("Java>=8 Point paralell translation starts:");  
        start = System.nanoTime();  
        
		IntStream.rangeClosed(0, OBJECTS).parallel()
		                                 .mapToObj(i -> new Point(i, i + 1))
		                                 .forEach(p -> p.translate(10, 12));    
        end = System.nanoTime() - start;  
        System.out.println("Java>=8 Points paralell Traslation took:  "   
                + NANOSECONDS.toMillis(end)/1000 + " seconds.");  
          
        // Sequential iteration (Iterator<> based) ...  
        System.out.println("Java<=7 Point sequential translation starts:");  
        start = System.nanoTime();  
        for (Point p : pl) {  
            p.translate(10, 12);  
        }  
        end = System.nanoTime() - start + endCreation;  
        System.out.println("Java<=7 Points Traslation took: "   
                + NANOSECONDS.toMillis(end)/1000 + " seconds.");  
    }  
}  