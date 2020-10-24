sumar(0,0):-!.
sumar(I,R):- I1 is I-1, sumar(I1,R1), R is R1+I.

sumarL([],0).
sumarL([F|L],R):- sumarL(L,R1),R is R1+F.

invertirLineal(L,R):-invertirLineal(L,[],R).
invertirLineal([],R,R).
invertirLineal([F|R],A,R1):- invertirLineal(R,[F|A],R1).