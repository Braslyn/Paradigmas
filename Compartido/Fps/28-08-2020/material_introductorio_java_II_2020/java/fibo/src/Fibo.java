/**
	<p> Standard example imperative versus recursive
@author loriacarlos@gmail.com
@since 2018 updated 2020
*/
package eif400fp.demo;
/*
 Encuentre la "pulga"
 Compilar
 javac -d classes src\Fibo.java
 Correr así para verla, por ejemplo
 java -cp classes -ea eif400fp.demo.Fibo 10
*/
public class Fibo {
	
	static long fib_rec( int n ) {
		return n <= 1 ? 1 : fib_rec(  n - 1 ) + fib_rec ( n - 2 );
	}
	static public long fibo_iter( int n ){
		if ( n <= 1 ) 
			return 1;
		long a = 2, b = 1;
		for (int i = 2; i <= n; i++){ 
			long t = a;
			a += b;
			b = t;
		}
		return a;	
	}
	public static void main(String... args){
		int max = 5;
		if (args.length > 0 ){
			max = Integer.parseInt(args[0]);
		}
		for (int n = 0; n <= max; n++) {
			assert fib_rec(n) == fibo_iter(n) : String.format("Fibo Failure at n=%2d %n", n);
			System.out.format("fibo_iter(%2d) = %2d =? %2d = fib_rec(%2d) %n", 
                              n, fibo_iter(n), fib_rec(n), n);
		}
	}	
}
