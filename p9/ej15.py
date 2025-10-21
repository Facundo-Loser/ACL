from enum import Enum

class TipoVehiculo(Enum):
    COMBUSTION = 0
    ELECTRICO = 1
    HIBRIDO = 2

class VehiculoCombustion():
    def __init__(self, capMaxL, marca, modelo):
         self.capMaxL = capMaxL  # cap max combustible
         self.capActualL = 0    # cant de litros de comb o kwh que tiene
         self.tipoV = TipoVehiculo.COMBUSTION    # tipo de vehículo (enum)
         self.marca = marca
         self.modelo = modelo

    def cargarCombustible(self, litros):
        if self.capActual + litros > self.capMaxL:
            self.capActual = self.capMaxL
        else:
            self.capActual += litros

    def descripcion(self):
        print(f"tipo vehículo: combustible")
        print(f"capacidad máxima: {self.capMaxL} L")
        print(f"marca: {self.marca}")
        print(f"modelo: {self.modelo}")

class VehiculoElectrico():
    def __init__(self, capMaxKwh, marca, modelo):
         self.capMaxKwh = capMaxKwh  # cap max kwh kilovatios hora
         self.capActualKwh = 0    # cant de litros de comb o kwh que tiene
         self.tipoV = TipoVehiculo.ELECTRICO    # tipo de vehículo (enum)
         self.marca = marca
         self.modelo = modelo

    def cargarBateria(self, kwh):
        if self.capActual + kwh > self.capMaxKwh:
            self.capActual = self.capMaxKwh
        else:
            self.capActual += kwh

    def descripcion(self):
        print(f"tipo vehículo: electrico")
        print(f"capacidad máxima: {self.capMaxKwh} KWH")
        print(f"marca: {self.marca}")
        print(f"modelo: {self.modelo}")

class VehiculoHibrido(VehiculoCombustion,VehiculoElectrico):
    pass

# ejemplo de uso:



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