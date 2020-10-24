// CJS
function nats(n=0,limit=Infinity){//{n,n+1,n+2,n+3,...,limit-1}
	function next(){
		return (n<limit)?{value:n++,done:false}:{value:undefined,done:true};
	}
	const iterator={next}
	return {[Symbol.iterator](){return iterator}}
}

function* nats_gen(n=0,limit=Infinity){
	while (n<limit){
		yield n++
	}
}
module.exports={
	nats,nats_gen
}

