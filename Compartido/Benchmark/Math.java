/**
* Demo
* Solucion al ejercicio 4 del Diagnostico I-2020
* Requiere jdk14 --enable-preview 
* Ejemplifica FP-OOP
* Copyright: NO distribuya sin permiso explicito del autor
* Para compilar de consola: Asumiendo Math.java en src
* javac  -d classes --enable-preview  --release 14 -nowarn src\Math.java
* Da warnings del preview pero se pueden ignorar
* Para correr:
* java --enable-preview -cp classes com.eif400.diagnostic.Math

@author loriacarlos@gmail.com
@Modify by braslynrrr999@gmail.coms
@since 2020

*/
//package com.eif400.diagnostic;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.*;
import java.util.function.*;


public class Math {
   /**
   * Modelo de estado inmutable explicito en un objeto
   */
   record EState(int i, double s, double t){
       public static EState initial(){
           return new EState(0, 0, 1);
       }
       public EState update(){
           return new EState( i + 1, s + t,  t / (i + 1) );
       }
       public boolean isFinal(int n){
           return i > n ;
       }
       
   }
   // Constantes para el demo
   static final double PRECISION   = 1e-15;
   static final int MAX_ITERATIONS = 20;
   static final double E = java.lang.Math.E;
   //////////////////////////////////////////////////////////////////////////
   /**
   * Version FP estado explicito e inmutable
   */
   public static double aproximeE_FP(){
       return aproximeE_FP(MAX_ITERATIONS, PRECISION);
   }
   public static double aproximeE_FP(int n){
       return aproximeE_FP(n, PRECISION);
   }
   public static double aproximeE_FP(int n, double epsilon){
       return    Stream.iterate( EState.initial(), EState::update  )
                       .filter( state -> state.isFinal( n ) )
                       .findFirst()
                       .get()
                       .s();
   }
   ////////////////////////////////////////////////////////////////////////////
   /**
   * Version recursiva de cola, estado explicito e  inmutable
   */
   private static double aproximeE_TAILREC(EState state, int n , double epsilon){
       return ( state.isFinal(n) ) 
              ? state.s() 
              : aproximeE_TAILREC(state.update(), n , epsilon);
   }
   public static double aproximeE_REC(int n, double epsilon){
       return aproximeE_TAILREC(EState.initial(), n, epsilon);
   }
   public static double aproximeE_REC(int n){
       return aproximeE_TAILREC(EState.initial(), n, PRECISION);
   }
   ///////////////////////////////////////////////////////////////////////////
   /**
   * Version iterativa clasica (estado mutable, estado no explicito en objeto)
   */
   public static double aproximeE_IMPER(int n){
       double s = 0;
       double t = 1;
       
       for (int i = 0; i <= n; i++){
           s += t;
           t = t / ( i + 1 );
           
       }
       return s;
   }
     ///////////////////////////////////////////////////////////////////////////
   /**
   * Version FP Parelela (estado mutable, estado no explicito en objeto)
   */
   
   
    public static double aproximeE_FPP(){
       return aproximeE_FP(MAX_ITERATIONS, PRECISION);
   }
   public static double aproximeE_FPP(int n){
       return aproximeE_FP(n, PRECISION);
   }
   public static double aproximeE_FPP(int n, double epsilon){
       return    Stream.iterate( EState.initial(), EState::update  ).parallel()
                       .filter( state -> state.isFinal( n ) )
                       .findFirst()
                       .get()
                       .s();
   }
   
public static void main(String[] args){
		
		long startTime = 0;
		long endTime = 0;
		long result=0;
		try{
		FileWriter csv= new FileWriter("Benchmark.csv");
       System.out.println("*** Benchmark aproximeE IMPER, REC, FP and FPP***");
	   csv.write("n;FP;Imperative;Recursive;Parallel FP;\n");
       for (int n =10; n < Integer.parseInt(args[0]); n++){
		   	csv.write(n+";");
			result=0;
			for(int j=0;j<1000;j++){
				startTime = System.nanoTime();
				aproximeE_FP(n);
				endTime = System.nanoTime();
				result+=(endTime-startTime);
			}
			csv.write(result/1000+";");
			result=0;
			for(int j=0;j<1000;j++){
				startTime = System.nanoTime();
				aproximeE_IMPER(n);
				endTime = System.nanoTime();
				result+=(endTime-startTime);
			}
			csv.write(result/1000+";");
			result=0;
			for(int j=0;j<1000;j++){
				startTime = System.nanoTime();
				aproximeE_REC(n);
				endTime = System.nanoTime();
				result+=(endTime-startTime);
			}
			csv.write(result/1000+";");
			result=0;
			for(int j=0;j<1000;j++){
				startTime = System.nanoTime();
				aproximeE_FPP(n);
				endTime = System.nanoTime();
				result+=(endTime-startTime);
			}
			csv.write(result/1000+";\n");
       }
       csv.close();
   }catch(IOException e){
	  System.out.println(e.getMessage());
   }
 }
}
