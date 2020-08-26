/**
Demo para Collectors
@author loriacarlos@gmail.com

*/
import java.util.Collection.*;

enum Gender{FEMALE, MALE}
record Person(String name, int age, Gender gender){
    int compareTo(Person p){
        return this.age() - p.age();
    }
}
var rand = new Random(666);
List<Integer> genAges(int a, int b, int max){
    return rand.ints(a, b).limit(max).boxed().collect(Collectors.toList());
}

List<Gender> genGenders(int max){
    return rand.ints().limit(max)
                          .boxed()
                          .map(n -> n % 2 == 1 ? Gender.FEMALE : Gender.MALE)
                          .collect(Collectors.toList());
}

List<Person> genPersons() throws Exception{
    var names = Files.lines(Paths.get("names.txt")).collect(Collectors.toList());
    var ages = genAges(18, 90, names.size());
    var genders = genGenders(names.size());
    return IntStream.range(0, names.size()).boxed()
           .map( i -> new Person(names.get(i), ages.get(i), genders.get(i) )) 
           .collect(Collectors.toList());
}

int ageMargin(List<Person> persons, Gender gender){
	return persons.stream().filter( x -> x.gender()==gender).
	collect( Collectors.teeing( Collectors.maxBy(Person::compareTo) , Collectors.minBy(Person::compareTo),
	(e1,e2) -> e1.get().age()-e2.get().age() ) );
}
 
var list = genPersons()
 
println("Diferencia de edad - > "+Gender.MALE+"-> "+ ageMargin(list ,Gender.MALE ) )
