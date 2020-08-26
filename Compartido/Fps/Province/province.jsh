import java.util.Collection.*;

enum Gender{FEMALE, MALE}
enum Province{HEREDIA,SANJOSE,CARTAGO,PUNTARENAS,GUANACASTE,LIMON,ALAJUELA}

record Person(String name, int age, Gender gender,Province province){
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

Province getProvince(int num){
	switch(num%7){
		case 0:
			return Province.LIMON;
		case 1:
			return Province.SANJOSE;
		case 2:
			return Province.ALAJUELA;
		case 3:
			return Province.CARTAGO;
		case 4:
			return Province.HEREDIA;
		case 5:
			return Province.PUNTARENAS;
		case 6:
			return Province.GUANACASTE;
	}
	return  Province.HEREDIA;
}
List<Province> genProvince(int max){
	return rand.ints().limit(max).boxed().map(x->getProvince(x)).collect(Collectors.toList());
}

List<Person> genPersons() throws Exception{
    var names = Files.lines(Paths.get("names.txt")).collect(Collectors.toList());
    var ages = genAges(18, 90, names.size());
    var genders = genGenders(names.size());
	var province= genProvince(names.size());
    return IntStream.range(0, names.size()).boxed()
           .map( i -> new Person(names.get(i), ages.get(i), genders.get(i),province.get(i))) 
           .collect(Collectors.toList());
}

int ageMargin(List<Person> persons, Gender gender){
	return persons.stream().filter( x -> x.gender()==gender).
	collect( Collectors.teeing( Collectors.maxBy(Person::compareTo) , Collectors.minBy(Person::compareTo),
	(e1,e2) -> e1.get().age()-e2.get().age() ) );
}

Map<Province, Map<Gender,List<Person>>> byProvinceAndGender(List<Person> persons){
	return persons.stream().collect(Collectors.groupingBy(Person::province,Collectors.groupingBy(Person::gender)));
}
var list = genPersons()
 



