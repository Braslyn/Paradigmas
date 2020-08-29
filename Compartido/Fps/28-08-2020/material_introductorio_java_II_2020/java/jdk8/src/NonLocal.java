/**
 <p>Simple samples of FP
 <p> Lambdas behaves are not closures
 @author loriacarlos@gmail.com
 @since 2020
*/
package eif400fp.demo.scope;
import java.util.function.*;
 
public class NonLocal{
  public static void main(String... args){
     int x = 0;
     Function<Integer, Integer> foo = y -> {x += y; return x;}; // It does not compile!
     System.out.format("antes=%d, %d, despues=%d", x, foo.apply(10), x);
  }
}