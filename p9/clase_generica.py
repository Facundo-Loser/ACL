from typing import TypeVar, Generic

# Definimos un parámetro de tipo genérico T
T = TypeVar('T')

class Caja(Generic[T]):
    def __init__(self, contenido: T):
        self.contenido = contenido

    def obtener(self) -> T:
        return self.contenido

    def __repr__(self):
        return f"Caja({self.contenido!r})"


# Caja de enteros
caja_enteros = Caja[int](42)
print(caja_enteros.obtener())   # 42

# Caja de cadenas
caja_texto = Caja[str]("Hola mundo")
print(caja_texto.obtener())     # "Hola mundo"

# Caja de listas
caja_lista = Caja[list[int]]([1, 2, 3])
print(caja_lista.obtener())     # [1, 2, 3]
