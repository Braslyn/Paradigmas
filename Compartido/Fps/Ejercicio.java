class A { int x= 666; int f(){return x;}}
class B extends A { int x= 777; int g(){return x;}}
class C extends A { int x= 888; int f(){return x;}}
B b = new B();
C c = new C();
println(b.x);    // qué pasó con la x de A?
println(b.f());  // cuanto imprime?
println(b.g()); // cuanto imprime?
println(c.f());  // cuanto imprime?

