enum Gender{Male,Female}
record Persona(String name,int age,Gender gender){}
new Persona("Enrique",21,Gender.valueOf("Female"));
List<Persona> list= Arrays.asList(new Persona("Enrique",100,Gender.valueOf("Female")),new Persona("ana", 30,Gender.valueOf("Female")), new Persona("carlitos", 70,Gender.valueOf("Male")),new Persona("Paco",100,Gender.valueOf("Male")),new Persona("Petronila",100,Gender.valueOf("Female")));
println("==Lista de Personas==\n")
list.stream().forEach(x->println(x))
println("\n")
int sumAgesByGender(List<Persona> personas, Gender g){
return personas.stream().filter(p-> p.gender()==g).map(per -> per.age()).reduce(0, (acumulador,pe)-> acumulador+pe);}
println("Suma de edades femeninas= "+sumAgesByGender(list,Gender.valueOf("Female")))
Persona oldest(List<Persona> persona){
	return persona.stream().reduce((p,q)-> p.age()<q.age()? q:p).get();}
println("Persona de mas edad -> "+oldest(list))
List<Persona> oldestWomen(List<Persona> persons) {
	var list= oldest(persons);
	return persons.stream().filter( x-> x.gender()==Gender.valueOf("Female")).filter(x-> x.age()== 100 ).reduce(new ArrayList<Persona>(),(x,y)->{x.add(y);return x;},(p,q)-> p);
}

println("Mujeres con mas edad: "+oldestWomen(list))

Function<Persona, Integer> f = x->x.age()

<T, R> CopyOnWriteArrayList<R> myMap(List<T> list, Function<T, R> f){
	return list.stream().reduce(new CopyOnWriteArrayList<R>(),(CopyOnWriteArrayList<R> x,y) -> {x.add( f.apply(y) ); return x;});
}

println("Mapeo con reduce: "+myMap(list,f))