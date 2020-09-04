public class Fibo {
	
	static 
	long fibo_rec( int n ) {
		return n <= 1 ? 1 : fibo_rec(  n - 1 ) + fibo_rec ( n - 2 );
	}
	static
	public long fibo_iter( int n ){
		// returns fib(n)
		if ( n <= 1 ) 
        return 1;
        long a = 2, b = 1;
        for (int i = 2; i <= n; i++){ 
            long t = a;
            a += b;
            b = t;
        }
        return b;
	}
	public static void main(String... args){
		int n = 0, max = 5;
		long sum = 0;
		if (args.length > 1 ){
			n = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
		}
        System.out.printf("*** Testing Fibo(%d) %d times ***%n", n, max);
		long before = System.currentTimeMillis();
		for (int i = 1; i <= max; i++) {
		    sum += fibo_iter(n); 
            sum += fibo_rec(n);
        }
		long after = System.currentTimeMillis();
		System.out.printf("%nEllapsed(sum=%d) %f s%n",  sum, (float)(after - before)/1000);
	}	
}
