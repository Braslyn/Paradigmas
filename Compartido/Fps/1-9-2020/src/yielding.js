function* caminador(n){
    yield 1
    yield 2
    if (n > 0)
        yield 3 
    else
        yield -3
    yield 4
}

function* yielderA(n){
    yield* yielderB(n)
}

function* yielderB(n){
    let  a = (new Array(n)).keys()
    yield* Array.from([...a], x => 2*x + 1)
    yield* 'hola!!'
}
module.exports = {
    caminador,
    yielderA
}