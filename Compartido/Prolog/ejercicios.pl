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
ultimo(X,[_|R]):-ultimo(X,R).
penultimo(X,[X,_]).
penultimo(X,[_|R]):- penultimo(X,R).




non_adjacent([F,R],X,Y):- append([F],X,R), non_adjacent(R,X,Y).


last(L,U):- foldl([X,_,M] >> (M = X), L,_,U).

occurs(L,V,N):- foldl([X,Y,Acc] >> ( X\==V -> Acc is Y ;X==V -> Acc is Y+1 ) , L , 0 , N).%mal pero casi bien