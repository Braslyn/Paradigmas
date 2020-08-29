/**
@author loriacarlos@gmail.com
@since II-2020
No distribuir sin permiso del autor fuera de sus grupos de EIF400 2020
*/

import java.util.stream.*;
import java.util.function.*;
public class Amdahl{
    
    public static void main(String... args){
        
        var me = new Amdahl();
        int nf = args.length == 0 ? 10 : Integer.parseInt(args[0].replace("_", "") );
        System.out.format("*** Calculating fact(%,d) ***%n", nf);
        me.test( "for",       () -> me.fact_for(nf) );
        me.test( "while",     () -> me.fact_while(nf) );
        me.test( "fp",        () -> me.fact_fp(nf) );
        me.test( "parallel",  () -> me.fact_fp_parallel(nf) );
        me.test( "recursive", () -> me.fact_rec(nf) );
        
    }
    public int test(String msg, Supplier<Integer> f){
        try{
            long start = System.currentTimeMillis();
            int res = f.get();
            long end = System.currentTimeMillis();
            double time = (end - start) / 1000.0;
            System.out.format( "%-10s: result=%d time=%1.6fsec %n", msg, res, time  );
            return res;
        } catch(Throwable e){
            System.out.format("*** %s ERROR--> %s ***", msg, e);
            return 0;
        } 
    }
    public int fact_rec(int n){
        return n == 0 ? 1 : n * fact_rec( n - 1);
    }
    public int fact_fp(int n){
        return IntStream.rangeClosed(1, n)
                        .reduce(1, (f, i) -> f * i);
    }
    public int fact_fp_parallel(int n){
        return IntStream.rangeClosed(1, n)
                        .parallel()
                        .reduce(1, (f, i) -> f * i);
    }
    public int fact_for(int n){
        int f = 1;
        for (int i = 2; i <= n; f *= i, i++);
        return f;
    }
    public int fact_while(int n){
        int f = 1;
        int i = 2;
        while ( i <= n){
            f *= i;
            i++;
        }
        return f;
    }
}
