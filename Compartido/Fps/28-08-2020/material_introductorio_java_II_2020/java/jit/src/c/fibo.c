/*
 From https://stackoverflow.com/questions/10192903/time-in-milliseconds
 http://pubs.opengroup.org/onlinepubs/7908799/xsh/systime.h.html
*/
#include <stdio.h> 
#include <stdlib.h>
#include <sys/time.h>

 
long fibo_rec( int n ) {
    return n <= 1 ? 1 : fibo_rec(  n - 1 ) + fibo_rec ( n - 2 );
}

long fibo_iter( int n ){
    // returns fib(n)
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
int  main (int argc, char *argv[]) {
	struct timeval stop, start;
	int init = 0, max = 5;
	long sum = 0;
	if (argc > 1 ){
			init = atoi(argv[1]);
			max = atoi(argv[2]);
		}
    printf("*** Testing Fibo(%d) %d times ***%n", init, max);
	gettimeofday(&start, NULL);
	for (int n = init; n <= max; n++) {
		    sum += fibo_iter(n); 
            sum += fibo_rec(n);
			//printf("fibo_iter( %3d ) = %3d =? %3d = fib_rec( %3d ) %n", n, fibo_iter(n), fib0_rec(n), n);
		}
	gettimeofday(&stop, NULL);
    double secs = (double)(stop.tv_usec - start.tv_usec) / 1000000 + (double)(stop.tv_sec - start.tv_sec);    
	printf("\nEllapsed(sum=%f) %ds\n",  sum, secs);
}