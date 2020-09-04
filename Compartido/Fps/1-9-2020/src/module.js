
const base = 0
function foo(x, y){
 return x + y + base
}

let goo = (x, y) => x + y + base

module.exports = {
   foo,
   goo
} 
 
