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


non_adjacent(L,X,Y):- append(_,[X,_|_],A),append(A,[Y|_],L).

%equi_distant([F|R], N, X, Y):- append([X|_],[_|Y],[F|R]).

last(L,U):- foldl([X,_,M] >> (M = X), L,_,U).

occurs(L,V,N):- foldl({V}/[X,Y,Acc] >> ( X\==V -> Acc is Y ;X==V -> Acc is Y+1 ) , L , 0 , N).%mal pero casi bien

%reduce(Lambda,L,V0,V):-

reduce(_,[],V0,V0).
reduce(Lambda,[F|L],V0,V):- call(Lambda,F,V0,Acc),reduce(Lambda,L,Acc,V).

map(_,[],[]).
map(Lambda,[F|L],[C|S]):- call(Lambda,F,C), map(Lambda,L,S).