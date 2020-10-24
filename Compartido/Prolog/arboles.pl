postfijo(Exp,[Exp]):- atomic(Exp).
postfijo(Exp,L):- Exp=..[Op,Left,Rigth],
						member(Op,['-','+','/','*']),
						postfijo(Rigth,L1),
						postfijo(Left,L2),
						postfijo(Op,L3),
						append(L2,L1,L4),
						append(L4,L3,L).
%Malo				
post(Exp,L,[Exp|L]):- atomic(Exp).
postfijo2(Exp,L):- Exp=..[Op,Left,Rigth],
						member(Op,['-','+','/','*']),
						post(Rigth,[],L1),
						post(Left,L1,L2),
						post(Op,L2,L3),
						reverse(L3,L).
						
eval(X,Mem,V):- atom(X),member([X,V],Mem).
eval(N,_,N):- number(N).
eval(T,Mem,R):- T=.. [Op,Left,Rigth],write(Op),
					member(Op,['-','+','/','*']),
					eval(Left,Mem,Vleft),
					eval(Rigth,Mem,VRight),
					Tval=..[Op,Vleft,VRight],
					R is Tval.