function quotrem(x, y){
    let quot = Math.floor(x / y)
    let rem  = x % y
    return {quot, rem}
}    
let {quot, rem } = quotrem(123, 8)
console.log(quotrem(123, 8))

module.exports = {
    quotrem
}  