declare
class Stack
   attr S

   meth init()
      S:=nil
   end

   meth push(V)
      S:=V|@S
   end

   meth pop(?V)
      case S of X|Xs then
	 V=X
	 S:=Xs
      end
   end

   meth getStack(?L)
      L = @S
   end
end

local S1 Aux1 Aux2 Aux3 L in
   S1 = {New Stack init()}

   L = {NewLock}
   thread lock L then {S1 push(1)} {S1 push(2)} {S1 pop(Aux1)} end end
   thread lock L then {S1 push(4)} {S1 pop(Aux2)} end end
   thread lock L then {S1 getStack(Aux3)} end end
   {Browse Aux3}
end