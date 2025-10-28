from typing import TypeVar, Generic, Iterable, List

T = TypeVar('T')

class A(Generic[T]):
    def __init__(self, element: T):
        self.element = element

    def setElement(self, element: T):
        self.element = element

    def getElement(self) -> T:
        return self.element
    

c1 = A[int](10)
print(f"elemento de c1: {c1.getElement()} y es de tipo: {type(c1.getElement())}")

c2 = A[str]("Hello World")
print(f"elemento de c1: {c2.getElement()} y es de tipo: {type(c2.getElement())}")


# para el ejercicio 13 alg. genérico:
def getMax(lista: Iterable[T]) -> T:
    # convierto el iterable en una lista:
    lista = list(lista)

    max = lista[0] # al principio el max es el primer elem
    for elem in lista:
        if max < elem:
            max = elem
    return max

numeros = [1,2,3,4,5,6,7,8,9]
print(f"max elem {getMax(numeros)}")

chars = ['a','b','c','d']
print(f"max elem {getMax(chars)}")

def invertirLista(lista: List[T]) -> List[T]:
    return lista[::-1]

print(f"lista invertida: {invertirLista([1,2,3,4,5,6])}")
print(f"lista invertida: {invertirLista(['a','b','c','d'])}")
