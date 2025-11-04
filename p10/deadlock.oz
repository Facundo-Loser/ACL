local TakeFork Philosopher in
   proc {Philosopher Id LeftFork RightFork}
      {Browse 'Filosofo '#Id#' pensando...'}
      {Delay 1000}

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
      {Philosopher Id LeftFork RightFork} % ciclo infinito
   end

   % -- main --
   local Fork1 Fork2 Fork3 in
      Fork1 = {NewLock}
      Fork2 = {NewLock}
      Fork3 = {NewLock}

      thread {Philosopher 1 Fork1 Fork2} end
      thread {Philosopher 2 Fork2 Fork3} end
      thread {Philosopher 3 Fork3 Fork1} end
   end
end
