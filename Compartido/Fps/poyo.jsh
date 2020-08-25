record EState(int i, double s, double t){
   public static EState initial(){
	   return new EState(0, 0, 1);
   }
   public EState update(){
	   return new EState( i + 1, s + t,  t / (i + 1) );
   }
   public boolean isFinal(int n, double epsilon){
	   return i > n && i<n+10;
}
}
double PRECISION   = 1e-15;
int MAX_ITERATIONS = 20;
double E = java.lang.Math.E;

public double aproximeE_FP(int n, double epsilon){
   return    Stream.iterate( EState.initial(), EState::update  )
				   .filter( state -> state.isFinal( n, epsilon ) )
				   .findFirst()
				   .get()
				   .s();
}

public double aproximeE_FPP(int n, double epsilon){
   return    Stream.iterate( EState.initial(), EState::update  ).parallel()
				   .filter( state -> state.isFinal( n, epsilon ) )
				   .findFirst()
				   .get()
				   .s();
}

long startTime = System.nanoTime();
aproximeE_FP(MAX_ITERATIONS,PRECISION)
long endTime = System.nanoTime();
println("That took " + (endTime - startTime)/1000000 + "seconds");

long startTime = System.nanoTime();
aproximeE_FPP(MAX_ITERATIONS,PRECISION)
long endTime = System.nanoTime();
println("That took " + (endTime - startTime)/1000000 + "seconds");

Stream.iterate( EState.initial(), EState::update  ).parallel().filter( state -> state.isFinal( 10 , PRECISION ) ).forEach(System.out::println);