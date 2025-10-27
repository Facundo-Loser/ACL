#include <iostream>

template <typename T>
class Lista {
private:
    T* datos;        // arreglo dinámico de elementos del tipo T
    size_t capacidad;
    size_t tamaño;

public:
    Lista(size_t cap) : capacidad(cap), tamaño(0) {
        datos = new T[capacidad];
    }

    ~Lista() {
        delete[] datos;
    }

    void agregar(const T& valor) {
        if (tamaño < capacidad) {
            datos[tamaño++] = valor;
        } else {
            std::cout << "Lista llena!\n";
        }
    }

    T& operator[](size_t index) {
        return datos[index];
    }

    size_t size() const {
        return tamaño;
    }
};

int main() {
    Lista<int> listaEnteros(5);   // lista que solo puede guardar ints
    listaEnteros.agregar(10);
    listaEnteros.agregar(20);

    for (size_t i = 0; i < listaEnteros.size(); i++) {
        std::cout << listaEnteros[i] << " ";
    }
    std::cout << std::endl;

    Lista<double> listaDoubles(3); // lista que solo guarda doubles
    listaDoubles.agregar(1.5);
    listaDoubles.agregar(2.7);

    for (size_t i = 0; i < listaDoubles.size(); i++) {
        std::cout << listaDoubles[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}
