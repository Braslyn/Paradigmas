
pow(N,0,1):-!.
pow(N,X,R):- X1 is X-1, pow(N,X1,R1), R is R1*N.



mymap(G,[],[]).
mymap(G,[L|R1],R):- mymap(G,R1,[R|R2]),R2 is G(L).
