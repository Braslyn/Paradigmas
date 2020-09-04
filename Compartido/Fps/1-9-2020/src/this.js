 
function foo(){
 let a = () => console.log("a", this==global)
 function b(){
     console.log("b", this == global)
 }
 a()
 b()
}
foo()
 
obj = {
    foo(){
        console.log("foo.obj", this==obj)
        let a = () => console.log("a", this==global)
        function b(){
        console.log("b", this == global)
        }
        a()
        b()
   }
}

obj.foo.call(this)
