record Fibonnachi(int i,int f1,int f2){
static Fibonnachi initial(){return new Fibonnachi(0,0,1);}
Fibonnachi upgrade(){return new Fibonnachi(i+1,f1+f2,f1);}
boolean isFinal(int n){return i==n;}
}
int FibboSquence(int n){
	return Stream.iterate(Fibonnachi.initial(),Fibonnachi::upgrade).filter(x->x.i()==n).findFirst().get().f1();
}
println("Secuencia de Fibonnachi")
IntStream.iterate(0,x->x+1).limit(24).forEach(x->println("i="+x+" -> "+FibboSquence(x)))


record Euclid(int x,int y,int q){
Euclid upgrade(){return new Euclid(x-y,y,q+1);}
boolean isFinal(){return x<y;}
List<Integer> Result(){return Arrays.asList(q,x);}
}

List<Integer> euclid2(int x, int y){
        int q = 0; int r = x;
        while (r >= y){
            q++; r -= y;
        }
        return Arrays.asList(q, r);
 }

List<Integer> euclid(int x, int y){
	return Stream.iterate(new Euclid(x,y,0), Euclid::upgrade).filter( Euclid::isFinal).findFirst().get().Result();
}
println("Secuencia de Euclid")
IntStream.iterate(1,x->x+1).limit(10).forEach(x->println("10 <= x="+x+" -> "+euclid(10,x)))