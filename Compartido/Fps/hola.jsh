record Person(String name, int age){}
Person p = new Person("Juan", 22);
p.age()
p.name()
p
List<Person>  personas=  Arrays.asList(new Person("ana", 30), p, new Person("carlitos", 70));
for(Person p : personas){
   suma += p.age();
}
suma
int sumarEdades(List<Person> persons){
    int suma = 0;
    for(Person p : persons)
       suma += p.age();
    return suma;
}
sumarEdades(personas)
personas
personas.stream()
var s= personas.stream();
s
personas.stream().map(p -> p.age() )
var x = personas.stream().map(p -> p.age() );
x.forEach(n -> System.out.println(n))
personas.stream().map(p -> p.age() ).reduce(0,(acumulador,n)-> acumulador+n )
int suma = personas.stream().map(p -> p.age() ).reduce(0 ,(acumulador,n)-> acumulador+n );
suma