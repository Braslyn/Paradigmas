BinaryOperator<Integer> swapArgs(BinaryOperator<Integer> f){
return (x,y)->{println("x: "+x+",y:"+y); return f.apply(y,x);};
}
BinaryOperator<Integer> x=(x,y)-> {println("x: "+x+",y:"+y); return x/y;};
swapArgs(x)
var n= swapArgs(x);
println(n.apply(1,2))
println(n.apply(2,1))