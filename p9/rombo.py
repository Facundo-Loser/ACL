class A:
    def __init__(self):
        print("Constructor de A")
    def msj(self):
        print("Hola desde A")

class B(A):
    def __init__(self):
        super().__init__()
        print("Constructor de B")

class C(A):
    def __init__(self):
        super().__init__()
        print("Constructor de C")

class D(B, C):
    def __init__(self):
        super().__init__()
        print("Constructor de D")

d = D()
d.msj()

print("Orden de resolución (MRO):")
print(D.__mro__)


# Con super() se sigue el MRO y A se llama una sola vez
# (sin super se construirian varias clases de A creo)


"""
En tu ejemplo, super().__init__() en B no solo llama al padre inmediato (A),
sino que colabora con las otras clases en la jerarquía para que el
constructor de A se ejecute una sola vez en todo el rombo.
"""
