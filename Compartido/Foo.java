/**
Demo solo para ser usado con javap
@author loriacarlos@gmail.com
@since II-2020
No distribuir sin permiso del autor fuera de sus grupos de EIF400 2020
*/

import java.util.stream.*;

public class Foo{
    
    public static void main(String... args){
        int n = 666;
        int m = 999;
        int r = n + m + 1;
        System.out.println(r);
        //
        String msg = "Un mensaje";
        String otro_msg = "Un mensaje";
        Foo me = new Foo();
        int nf = 5;
        me.fact_for(nf);
        me.fact_while(nf);
        me.fact_fp(nf);
        me.fact_rec(nf);  
    }
    
    public int fact_rec(int n){
        return n == 0 ? 1 : n * fact_rec( n - 1);
    }
    public int fact_fp(int n){
        return IntStream.rangeClosed(1, n)
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
