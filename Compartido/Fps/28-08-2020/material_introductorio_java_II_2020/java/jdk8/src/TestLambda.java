/**
 <p>Simple samples of FP
 <p> Lambdas behaves like objects
 @author loriacarlos@gmail.com
 @since 2015 updated 2020
*/
package eif400fp.demo.basic;
import java.util.*;
import java.util.function.*;

public class TestLambda{
	
   public static void main(String[] args){
	 System.out.println("*** Demo using lambda as an Object ***");
     Map<String, Function<Integer, Integer>> ht = new Hashtable<>();
     System.out.println("ht is a Hashtable<String, Function<Integer, Integer>>");
	 // Stores a lambda. Notice type inference working
	 ht.put("foo", x -> x * x);
     System.out.format("ht['foo'] == x -> x * x%n");
	 // Retrieves lambda and apply it (.apply is required!)
	 System.out.format("ht['foo'](666)=%d%n", ht.get("foo").apply( 666 ));
	 
	 // Functions behaves like a regular object
	 System.out.format("ht['foo'] types is: %s", ht.get("foo").getClass().getName());
   }
}