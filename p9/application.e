class
    VEHICULO
feature
    encender_motor
        do
            print("Motor del vehículo encendido.%N")
        end
end


class
    AVION
feature
    despegar
        do
            print("El avión despega.%N")
        end
end


class
    AVIONETA
        inherit
            VEHICULO
            AVION
feature
    volar
        do
            print("La avioneta está volando.%N")
        end
end


class
    APPLICATION
create
    make
feature
    make
        local
            a: AVIONETA
        do
            create a
            a.encender_motor
            a.despegar
            a.volar
        end
end
