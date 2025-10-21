import inspect

class A:
    def random():
        print("aaaa")

class B(A): pass

class C(B): pass

obj = B()
obj2 = A()

print(inspect.isclass(A))            # ver si un arg es una clase
print(inspect.isclass(obj))          # ver si un arg es una clase
print(inspect.ismethod(obj2.random)) # ver si un arg es un met de una clase
print(inspect.getmro(C))             # ver jerarquia de clases
