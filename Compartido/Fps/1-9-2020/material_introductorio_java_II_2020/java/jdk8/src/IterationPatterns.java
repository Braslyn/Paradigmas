/**
  * Comparing iteration patters in Java iterators-forach-lambdas
  * Control en el lenguage versus en la coleccion
  * First meeting with lambdas and streams
  @author loriacarlos@gmail.com
  @since 2015 updated 2020
*/

package eif400fp.demo.iteration;

import java.util.stream.*; 
import java.util.Iterator;

class Naturals implements Iterable<Integer>{
		private int init = 0;
		private int max = 100;
		public Naturals(){this(0, Integer.MAX_VALUE);}
		
		public Naturals(int init, int max){
			this.init = init;
			this.max = max;
		}
		public Iterator<Integer> iterator(){ return new NatIterator(init, max);}
	}
class NatIterator implements Iterator<Integer>{
		private int init = 0;
		private int max = 0;
		private int current = 0;
		public NatIterator(int init, int max){
			this.init = init;
			this.max = max;
		}
		public boolean hasNext(){return current < max;}
		public Integer next(){return current++;}
		public void remove(){ current--;}


	}
public class IterationPatterns{
    public static void main(String[] args){
	    // Imprimir los primeros 11 naturales pares
		// 1) Estilo jdk <= 4. Hay que implementar interfaz e iterador
		Naturals nats4 = new Naturals();
		Iterator<Integer> iter = nats4.iterator();
		while(iter.hasNext()){
		       int n = iter.next();
		       if(n > 10) break; 
		       if(n % 2 == 0) 
		         System.out.println(n);
		}
	    // 2) Estilo JDK>= 5-7: Hay que implementar interfaz e iterador
		Naturals nats7 = new Naturals();
		for(int n : nats7){
		   if(n > 10) break;
		   if(n % 2 == 0) 
		    System.out.println(n);
		}
		
		// 3) Estilo JDK >= 8
	    IntStream nats8 = IntStream.iterate(0, n -> n + 1);
		nats8.limit(11)
		     .filter(n -> n % 2 == 0)
			 .forEach(n -> System.out.println(n));
		
		
	}
}