/**
<p> Pequeño ejemplo/ejercicio colecciones usando combinadores/lambda (jdk>=8)
<p> Implemente los metodos en estilo FP
@author loriacarlos@gmail.com
@since 2016 udated 2020
*/
/*
Para usar record requiere --enable-preview -source 14 (y --enable-preview en java)
*/
package eif400fp.demo.combs;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

enum Genero{
	M, F;
	
}
/*
class Persona{
	String nombre;
	int edad;
	Genero genero;  
	Persona(String nombre, Genero genero, int edad){
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
	}
	public String toString(){
	     return String.format("{nombre: %s, edad: %d, genero:%s}", nombre, edad, genero);
	}
	
}*/
/*
Feature potencial en jdk14
*/
record Persona(String nombre, Genero genero, int edad){}

public class TestCollections {
	static String[] nombres   = {"Ana", "Maria", 
                                 "Pedro", "Juan", 
                                 "Luis", "Alberto", 
                                 "Jose" };
    static String[] apellidos = {"Ruiz", "Perez", 
                                  "Gomez", "Arce", 
                                  "Soto", "Ramirez", 
                                  "Gomez", "Sanchez" };
	final static Random rand = new Random(666);
	final static int MAX = 100;
	
	List<Persona> lp;
	public TestCollections(){
		this.lp = initPersonas();
	}
	public static Persona genPersona(){
		int edad = rand.nextInt(100);
		Genero genero = rand.nextBoolean() ? Genero.M : Genero.F;
		String nombre = apellidos[rand.nextInt(apellidos.length)] 
                        + ", " 
                        + nombres[rand.nextInt(nombres.length)]; 
		return new Persona(nombre, genero, edad);
	}
	List<Persona> initPersonas(){
        //todo: convierta a FP
		List<Persona> lp = new ArrayList<>();
		for(int i = 0 ; i < MAX; i++){
			lp.add(genPersona());
		}
		return lp;
	}
	public int cuantosHombres(){
		// to do: haga en FP
        return -1;
	}
	public int cuantasMujeres(){
		// to do: haga en FP
        return -1;
	}
	public int cuantasMujeresMayoresQue(int max){
		// to do: haga en FP
        return -1;
	}
    public void print(){
        IntStream.range(0, this.lp.size())
                 .forEach(i -> {
                     System.out.format("%2d) %s%n", i, this.lp.get(i));
                 });
    }
	public static void main(String[] args){
		TestCollections tc = new TestCollections();
		tc.print();
        System.out.println("*** Algunos resultados ***");
        System.out.format("Hombres= %d%n", tc.cuantosHombres());
        System.out.format("Mujeres= %d%n", tc.cuantasMujeres());
        System.out.format("Mujeres>40= %d%n", tc.cuantasMujeresMayoresQue(40));
	}
}