/**
 Un arco numerado
*/
package com.eif400.dignostic;
class  NumberedEdge<T> extends Edge<T>{
      /**
         Un numero de identificacion
      */
      protected int number;
      
      public NumberedEdge(int number, Node<T> source, Node<T> target){
          super(source, target);
          this.number = number;
      }
      public int number(){
          return this.number;
      }
      @Override
      public String toString(){
          return String.format("%s -[%d]-> %s ", this.source.toString(), this.number, this.target.toString());
      }
} 