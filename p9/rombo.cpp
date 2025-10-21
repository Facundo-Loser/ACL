#include <iostream>

class A {
    public:
    A() { std::cout << "Constructor de A" << std::endl; }
    void msj() { std::cout << "msj A" << std::endl; }
};

class B : virtual public A {
    public:
    B() { std::cout << "Constructor de B" << std::endl; }
};

class C : virtual public A {
    public:
    C() { std::cout << "Constructor de C" << std::endl; }
};

class D : public B, public C {
    public:
    D() { std::cout << "Constructor de D" << std::endl; }
};

int main(void) {
    D d;
    d.B::msj();
    d.C::msj();
    return 0;
}



/*
 En el caso de C++, el problema de nombres no existe ya
 que es posible referenciar a un miembro específico de
 una clase utilizando el operador de alcance (símbolo ::)

 El problema de la repetición de atributos se resuelve en
 C++ definiendo en una de las ramas de la herencia (en el
 ejemplo, podría ser en la clase B) que se hereda de la
 superclase (A) en forma virtual.


 si saco el virtual de B y C se crea la clase A 2 veces:

 *sin usar virtual:*
 facu@Facundo:~/ACL/p9$ ./rombo
 Constructor de A
 Constructor de B
 Constructor de A
 Constructor de C
 Constructor de D
 msj A
 msj A

 *usando virtual:*
 facu@Facundo:~/ACL/p9$ g++ rombo.cpp -o rombo
 facu@Facundo:~/ACL/p9$ ./rombo
 Constructor de A
 Constructor de B
 Constructor de C
 Constructor de D
 msj A
 msj A

 *el virtual permite el dispatching dinámico, por ende:*
 B y C no deben tener su propia copia de A;
 deben compartir una única instancia común de A,
 que será manejada por el objeto más derivado (D).

 Sin virtual → cada rama tiene su propia copia física de A
 Con virtual → las ramas comparten una referencia al mismo A
 */

