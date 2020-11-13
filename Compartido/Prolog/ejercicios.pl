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

last(L,U):- foldl([X,_,M] >> (M = X), L,_,U).
last2(L,U):- foldl([X,_,X]>>true, L,_,U).

occurs(L,V,N):- foldl({V}/[X,Y,Acc] >> ( X==V -> (Acc is Y+1);(Acc is Y) ) , L , 0 , N).%mal pero casi bien


reduce(_,[],V0,V0).
reduce(Lambda,[F|L],V0,V):- call(Lambda,F,V0,Acc),reduce(Lambda,L,Acc,V).

map(_,[],[]).
map(Lambda,[F|L],[C|S]):- call(Lambda,F,C), map(Lambda,L,S).

:- dynamic data/1.

reduce2(_,_,V0,_):- 
	retractall(data(_)),
	assert(data(V0)),
	fail.
	
reduce2(Lambda,L,_,_):-
	member(F,L),
	retract(data(B)),
	call(Lambda,F,B,V),
	assert(data(V)),
	fail.
	
reduce2(_,_,_,V):- retract(data(V)).

add(z,N,N).
add(s(N),M,R):- add(N,s(M),R).

mult(z,N,N).
mult(s(M),N, R):- add(N,MN,R),mult(M,N,MN).

toNum(z,0).
toNum(s(N),M):- toNum(N,M0), M is M0+1.
%toNum(p(N),M):- toNum(N,M0), M is M0-1.


simplify(z,_).
simplify(s(N),R):-simplify(N,s(R)).
simplify(p(N),R):-simplify(N,p(R)).


punto_medio(A,X,L,R):- length(A,_var),Length is _var//2,append(L,[X|R],A), length(L,Length),!.

equi_distant(L, N, X, Y):- append(_,[X|R],L),append(M,[Y|_],R),length(M,N).

non_adjacent(L,X,Y):- append(_,[X,_|_],A),append(A,[Y|_],L).


test_listas :- 
    atomic_list_concat(Tokens, ' ',  '[ 1 , 2 , 3 ]'),
    lista(List, Tokens, []),
    List = [1,2,3].


lista(X)--> ['['],digits(X),[']'].
digits([])-->[].
digits([F|R]) --> digit(F),digits2(R).
digits2([])-->[].
digits2([F])--> digit(F). 
digits2([F|R])-->[','],digit(F),digits2(R).
digit(N)--> [X],{atom_number(X,N)}.





