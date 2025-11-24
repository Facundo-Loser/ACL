-module(prod_cons_simple).
-export([start/0, productor/2, consumidor/0]).

start() ->
    CONSUMER_PID = spawn(prod_cons_simple, consumidor, []),
    io:format("consumidor iniciado~n"),
    spawn(prod_cons_simple, productor, [CONSUMER_PID, 0]),
    io:format("productor iniciado~n").

productor(Pid_consumidor, Number_task) ->
    if Number_task =< 4 ->
        Pid_consumidor ! {task, Number_task},
        io:format("productor envio mensaje~n"),
        productor(Pid_consumidor, Number_task+1); %% se llama recursivamente
                                                  %% hasta que number_task==4
    true ->
        Pid_consumidor ! finished,
        io:format("productor envio todos los mensajes~n")
    end.

consumidor() ->
    receive
        {task, N} ->
            io:format("consumidor recibio ~p~n", [N]),
            consumidor(); %% llamada recursiva
        finished ->
            io:format("consumidor consumio todo~n");
        _Other ->
            io:format("consumidor recibio algo inesperado"),
            consumidor()
    end.
