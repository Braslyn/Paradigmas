"use strict";
const Gender = Object.freeze({
MALE:{value:"male"},
FEMALE:{value:"female"}
})

class Person{
    constructor(name, age){
        this.name = name
        this.age = age
    }
}
module.exports ={
    Gender,
    Person
    
} 