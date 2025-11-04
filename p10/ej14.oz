   case L of nil then skip
   [] X|Xs then
      case X of _ then {Barrier Xs} end
   end
