postfijo(Exp,[Exp]):- atomic(Exp).
postfijo(Exp,L):- Exp=..[Op,Left,Rigth],
						member(Op,['-','+','/','*']),
						postfijo(Left,L1),
						postfijo(Rigth,L2),
						postfijo(Op,L3),
						append(L2,L1,L4),
						append(L4,L3,L).
						
eval(X,Mem,V):- atom(X),member([X,V],Mem).
eval(N,_,N):- number(N).
eval(T,Mem,R):- T=.. [Op,Left,Rigth],
					member(Op,['-','+','/','*']),
					eval(Left,Mem,Vleft),
					eval(Rigth,Mem,VRight),
					Tval=..[Op,Vleft,VRight],
					R is Tval.