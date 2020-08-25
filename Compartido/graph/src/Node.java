/**
 Un simple nodo
*/
package com.eif400.dignostic;

class Node<T>{
    protected T value;
    public T value(){
        return this.value;
    }
    public Node(T value){
        this.value = value;
    }
    public String toString(){
          return this.value.toString();
    }
    
} 