/**
 Un simple arco
*/
package com.eif400.dignostic;
class  Edge<T> {
      protected Node<T> source, target;
      
      public Edge(Node<T> source, Node<T> target){
          this.source = source;
          this.target = target;
      }
      public Node<T> source(){
          return this.source;
      }
      public Node<T> target(){
          return this.target;
      }
      public String toString(){
          return String.format("%s -> %s ", this.source.toString(), this.target.toString());
      }
} 