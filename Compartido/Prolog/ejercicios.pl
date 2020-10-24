/*
@author Braslynrrr999@gmail.com
@since EIF400-2020
* app(end) home made
*/

primero([X|_],X).
resto([_|X],X).
cons(L,E,[E|L]).
pertenece(X,[X|_]).
pertenece(X,[_|L]):- pertenece(X,L).
conc([],Y,Y).
conc([F|R],Y,[F|Z]):- conc(R,Y,Z).
ultimo(X,[X]).
ultimo(X,[F|R]):-ultimo(X,R).
penultimo(X,[X,_]).
penultimo(X,[F|R]):- penultimo(X,R).