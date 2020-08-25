/**
 Material para una serie de ejercicios de Java
 @author loriacarlos@gmail.com
 @since 2020
*/
package com.eif400.dignostic;

import java.util.*;
/**
  * Clase principal que modela un digrafo simple
  <p> Experimental
  <P> Carece de chequeos y validaciones
*/  
public class SimpleDigraph<T> {
    /**
       * Clase para retornar el Resultado de un dfs
    */
    static class DfsResult<T>{
       /** Nodo de arranque de la visita */
       Node<T> start;
       /** 
        *Lista de nodos del path recorrido 
       */
       public List<Node<T>> path;
       /** 
         * Conjunto de nodos que no fueron alcanzados 
       */
       public Set<Node<T>> unvisited;
       DfsResult(Node<T> start, List<Node<T>> path, Set<Node<T>> unvisited){
           this.path = path;
           this.unvisited = unvisited;
           this.start = start;
       }
    }
    
    /**
     Los nodos
    */
    Set<Node<T>> nodes = new HashSet<Node<T>>();
    /**
      Los arcos
    */
    Set<Edge<T>> edges = new HashSet<Edge<T>>();
    /**
      * "Matriz" de incidencia
    */
    Map<Node<T>, Set<Node<T>>> incidence = new HashMap<Node<T>, Set<Node<T>>>();
    
     
    /**
      *Inicializa el grafo. Es un prototipo
      * No hace validaciones
      * Asume que los nodes y los arcos estan correctamente construidos
      * Asume que es un digrafo simple
      @param nodes los nodos del grafo
      @param edges los arcos del grafo
    */
    public SimpleDigraph(List<Node<T>> nodes, List<Edge<T>> edges){
        
        this.nodes.addAll(nodes);
        this.edges.addAll(edges);
        for (var n: nodes){
            incidence.put(n, new HashSet<>());
        }
        for (var edge : edges){
            this.incidence.get(edge.source()).add(edge.target());  
        }
    }
    /**
      Retorna los vecinos de un nod
      @param n el nodo saliente
      @return el conjunto de sucesores
    */
    public Set<Node<T>> successors(Node<T> n){
        return this.incidence.get(n);
    }
    /**
      Recorre el grafo en modo dfs empezando en start
      @param start el nodo de arranque
      @return un DfsResult
    */
    public DfsResult<T> dfs(Node<T> start){
        throw new RuntimeException("\n>>> dfs no esta implementado <<<\n");
    }
    
    public static void main(String... args){
        System.out.println("*** Very Simple Demo of DFS ***");
        
        var a = new Node<String>("a"); //0
        var b = new Node<String>("b"); //1
        var c = new Node<String>("c"); //2
        var d = new Node<String>("d"); //3
        var x = new Node<String>("x"); //4
        var y = new Node<String>("y"); //5
        var z = new Node<String>("z"); //6
        
        List<Node<String>> nodes = Arrays.asList(a, b, c, d, x, y, z);
        
        List<Edge<String>> edges = Arrays.asList(
            new Edge<String>(x, x),
            new Edge<String>(a, b),
            new Edge<String>(b, a),
            new Edge<String>(a, c),
            new Edge<String>(b, c),
            new Edge<String>(a, c),
            new Edge<String>(x, c),
            new Edge<String>(y, z),
            new Edge<String>(c, d),
            new Edge<String>(y, x),
            new Edge<String>(a, x)
        );
        
        var graph = new SimpleDigraph<String>(nodes, edges);
        var start = a;
        System.out.format("*** Visit starting at %s ***%n", start);
        DfsResult<String> result = graph.dfs(start);
        var path = result.path;
        var unvisited = result.unvisited;
        System.out.format("*** Results of DFS started at %s ***%n", result.start);
        for (var e : result.path){
            System.out.println(e);
        }
        System.out.println("*** Following nodes were not visited ***");
        for(var n : result.unvisited){
            System.out.println(n);
        }
        
    }
}