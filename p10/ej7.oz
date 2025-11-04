local C1 C2 Y L in
   L={NewLock}
   C1={NewCell 1}
   C2={NewCell 2}
   thread C1:=@C2*3 lock L then C2:=@C2*2 end end
   thread  lock L then C2:=@C2*2 end Y=2 end
   {Browse @C1}
   {Browse @C2}
end
