-module(areaserver).
-export([start/0, loop/0]).

start() -> spawn(areaserver, loop, []).

loop() ->
    receive
        {From, Shape} ->
            Area = geometry:area(Shape),   % usamos la función del módulo geometry
            From ! {area, Area},           % enviamos el resultado al proceso que pidió
            loop()
    end.