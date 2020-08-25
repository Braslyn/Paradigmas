/**
 Un simple nodo
*/
package com.eif400.dignostic;

class NumberedNode<T> extends Node<T>{
    protected int number;
    public NumberedNode(int number, T value){
        super(value);
        this.number = number;
    }
    @Override
    public String toString(){
          return String.format("%s with number %d", this.value, this.number);
    }
    
} 