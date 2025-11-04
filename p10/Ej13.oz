local MyWait X in
   proc {MyWait X}
      if X==X then skip else skip end % se suspende hasta que X no tenga algo
   end

  % thread {Delay 2000} X=10 end
   thread X=10 end
   {MyWait X}
   {Browse X}
end
