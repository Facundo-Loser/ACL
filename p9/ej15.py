class Vehiculo():
    def __init__(self, marca, modelo):
        self.marca = marca
        self.modelo = modelo

class VehiculoCombustion(Vehiculo):
    def __init__(self, capMaxL, marca, modelo):
        Vehiculo.__init__(self, marca, modelo)
        self.capMaxL = capMaxL # cap maxima de combustible
        self.capActualL = 0    # cap actual de combustible

    def cargarCombustible(self, litros):
        if self.capActualL + litros > self.capMaxL:
            self.capActualL = self.capMaxL
        else:
            self.capActualL += litros

    def descripcion(self):
        print(f"tipo vehículo: combustible")
        print(f"capacidad máxima: {self.capMaxL} L")
        print(f"marca: {self.marca}")
        print(f"modelo: {self.modelo}")

class VehiculoElectrico(Vehiculo):
    def __init__(self, capMaxKwh, marca, modelo):
            Vehiculo.__init__(self, marca, modelo)
            self.capMaxKwh = capMaxKwh # cap maxima de kilovatios
            self.capActualKwh = 0      # cap actual de kwh

    def cargarBateria(self, kwh):
        if self.capActualKwh + kwh > self.capMaxKwh:
            self.capActualKwh = self.capMaxKwh
        else:
            self.capActualKwh += kwh

    def descripcion(self):
        print(f"tipo vehículo: electrico")
        print(f"capacidad máxima: {self.capMaxKwh} KWH")
        print(f"marca: {self.marca}")
        print(f"modelo: {self.modelo}")

class VehiculoHibrido(VehiculoCombustion,VehiculoElectrico):
    def __init__(self, capMaxL, capMaxKwh, marca, modelo):
        VehiculoCombustion.__init__(self, capMaxL, marca, modelo)
        VehiculoElectrico.__init__(self, capMaxKwh, marca, modelo)

    def descripcion(self):
        print("tipo vehiculo: hibrido")
        print(f"capacidad máxima: {self.capMaxL} L")
        print(f"capacidad máxima: {self.capMaxKwh} KWH")
        print(f"capacidad actual L: {self.capActualL}")
        print(f"capacidad actual Khw: {self.capActualKwh}")
        print(f"marca: {self.marca}")
        print(f"modelo: {self.modelo}")

# ejemplo de uso:
h = VehiculoHibrido(50, 100, "Toyota", "Prius")
h.descripcion()
h.cargarCombustible(44)
h.cargarBateria(90)
print("****")
h.descripcion()

print("chequear el MRO:")
print(VehiculoHibrido.__mro__)

"""
MRO:
(<class '__main__.VehiculoHibrido'>,
<class '__main__.VehiculoCombustion'>,
<class '__main__.VehiculoElectrico'>,
<class '__main__.Vehiculo'>, <class 'object'>)
"""


"""
Esquema de herencias:
                         [clase Vehículo]
                         ^              ^
                         |              |
                         |              |
 [clase VehiculoCombustion]            [clase VehiculoElectrico]
                          ^            ^
                          |            |
                          |            |
                     [clase VehiculoHibrido]
"""

# MRO: [VehiculoHibrido, VehiculoCombustion, VehiculoElectrico, object]
