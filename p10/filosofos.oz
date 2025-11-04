local Philosopher in
   proc {Philosopher Id LeftFork RightFork NormalOrder}
      {Browse 'Filosofo '#Id#' pensando...'}
      {Delay 1000}

      if NormalOrder then % Orden normal (LeftFork -> RighFork)
	 {Browse 'Filosofo '#Id#' intenta tomar el fork izquierdo'}
	 lock LeftFork then
	    {Browse 'Filosofo '#Id#' tomo el fork izquierdo'}
	    {Browse 'Filosofo '#Id#' intenta tomar el fork derecho'}
	    lock RightFork then
	       {Browse 'Filosofo '#Id#' tomo el fork derecho'}
	       {Browse 'Filosofo '#Id#' comiendo'}
	       {Delay 2000}
	    end
	    {Browse 'Filosofo '#Id#' solto el fork derecho'}
	 end
	 {Browse 'Filosofo '#Id#' solto el fork izquierdo'}
      else % Orden Invertido (RightFork -> LeftFork)
	 {Browse 'Filosofo '#Id#' intenta tomar el fork derecho'}
	 lock RightFork then
	    {Browse 'Filosofo '#Id#' tomo el fork derecho'}
	    {Browse 'Filosofo '#Id#' intenta tomar el fork izquierdo'}
	    lock LeftFork then
	       {Browse 'Filosofo '#Id#' tomo el fork izquierdo'}
	       {Browse 'Filosofo '#Id#' comiendo'}
	       {Delay 2000}
	    end
	    {Browse 'Filosofo '#Id#' solto el fork izquierdo'}
	 end
	 {Browse 'Filosofo '#Id#' solto el fork derecho'}
      end
      {Philosopher Id LeftFork RightFork NormalOrder} % ciclo infinito
   end

   % -- main --
   local Fork1 Fork2 Fork3 in
      Fork1 = {NewLock}
      Fork2 = {NewLock}
      Fork3 = {NewLock}

      thread {Philosopher 1 Fork1 Fork2 true} end
      thread {Philosopher 2 Fork2 Fork3 true} end
      thread {Philosopher 3 Fork3 Fork1 false} end % el ult debe tomar los tenedores al reves
   end
end
