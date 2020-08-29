package eif400fp.demo.primes;
import java.util.stream.*;
import java.util.*;

/**
	<p> find the first prime between a and b using imperative and FP style
	<p>Illustrates lazyness and iteration styles
	<p>Collection versus iteration
@author loriacarlos@gmail.com
@since 2020
*/
public class FirstPrime {
    /**
	  *Iterative Version of isPrime
	  *@param n number to test
	  *@return true if n is prime
	*/
    static public boolean isPrime(int n){
	   if(n <= 1) return false;
	   for(int i = 2; i*i <= n; i++){
	      if(n%i == 0) 
              return false;
	   }
	   
	   return true;
	  
	}
	/**
	  *FP Version of isPrime
	  *@param n number to test
	  *@return true if n is prime
	*/
	static public boolean isPrimeFP(int n){
       int max = (int)Math.sqrt(n);
	   /*return IntStream.range(2, max)
					   .noneMatch( i -> n % i == 0);*/
       return IntStream.range(2, max)
					   .anyMatch( i -> n % i != 0);
       /*return !IntStream.range(2, max)
                .filter(i -> n % i == 0)
                .findFirst()
                .isPresent();*/
       /*return !IntStream.iterate(2, i -> i + 1)
                       .limit(max)
                       .filter(i -> n % i == 0)
                       .findFirst()
                       .isPresent();*/
       
	                   
	}
    /**
	  *Imperative Version of findFirstPrime
	  *@param a lower bound
      *@param b upper bound
	  *@return first prime in [a, b] if any found; -1 otherwise
	*/
    static public int findFirstPrime(int a, int b){
        for (int i = a; i <= b; i++){
            if (isPrime(i)) return i;
        }
        return -1;
    }
    /**
	  *FP Version of findFirstPrime
	  *@param a lower bound
      *@param b upper bound
	  *@return first prime in [a, b] if any found; -1 otherwise
	*/
	static public int findFirstPrimeFP(int a, int b){
	    OptionalInt f = IntStream.rangeClosed(a, b)
                                 .filter(i -> isPrimeFP(i))
						         .findFirst();
						  
		if(f.isPresent()) return f.getAsInt();
		else return -1;

	}
	public static void main(String... args) throws Exception {
       System.out.println("*** Imperative verus FP prime search ***");
	   long before, after;
	   int fp = 0;
	   long times = 200_000;
       int a = 3002005;
       int b = 15000000;
       // Test FP
       before = System.currentTimeMillis();
	   for(long i = 1; i < times; i++){
	     fp = findFirstPrimeFP(a, b);
	   }
	   after = System.currentTimeMillis();
	   System.out.format("%n*** Results FP (%d times) ***%n", times);
	   System.out.format("First prime: %d%n", fp);
	   System.out.format("FP Average Ellapsed time: %f ms%n", (double)(after - before)/times);
       // Test Imperative
       System.out.println();
       before = System.currentTimeMillis();
       for(long i = 1; i < times; i++){
	     fp = findFirstPrime(a, b);
	   }
       after = System.currentTimeMillis();
       System.out.format("%n*** Results Imperative (%d times) ***%n", times);
	   System.out.format("First prime: %d%n", fp);
	   System.out.format("Imperative Average Ellapsed time: %f ms%n", (double)(after - before)/times);
	
	}
	
	
}