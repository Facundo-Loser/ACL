declare
class Counter
   attr val
   meth init(V)
      val := V
   end
   meth inc(V)
      val := @val + V
   end
   meth get(V)
      V = @val
   end
end

local C A B D in
   C = {New Counter init(0)}
   {C get(A)}
   {Browse A}
   {C inc(1)}
   {C get(B)}
   {Browse B}
   {C inc(7)}
   {C get(D)}
   {Browse D}
end
