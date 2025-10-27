#include <iostream>
#include <any>
#include <vector>
#include <memory>
using namespace std;

class Lista {
public:
    virtual void agregar(any elem) = 0;
    virtual any obtener(int index) const = 0;
    virtual void eliminar(int index) = 0;
    virtual int tam() const = 0;
    virtual ~Lista() = default;
};


// implementación con arreglo:
class ListaArray : public Lista {
private:
    vector<any> datos;

public:
    void agregar(any elem) override {
        datos.push_back(elem);
    }

    any obtener(int index) const override {
        if (index >= 0 && index < (int)datos.size())
            return datos[index];
        return {};
    }

    void eliminar(int index) override {
        if (index >= 0 && index < (int)datos.size())
            datos.erase(datos.begin() + index);
    }

    int tam() const override {
        return datos.size();
    }
};

// implementación lista enlazada:
struct Nodo {
    any dato;
    Nodo* sig;
    Nodo(any d) : dato(d), sig(nullptr) {}
};

class ListaEnlazada : public Lista {
private:
    Nodo* cabeza = nullptr;
    int cantidad = 0;

public:
    void agregar(any elem) override {
        Nodo* nuevo = new Nodo(elem);
        if (!cabeza)
            cabeza = nuevo;
        else {
            Nodo* aux = cabeza;
            while (aux->sig)
                aux = aux->sig;
            aux->sig = nuevo;
        }
        cantidad++;
    }

    any obtener(int index) const override {
        Nodo* aux = cabeza;
        for (int i = 0; i < index && aux; i++)
            aux = aux->sig;
        return aux ? aux->dato : any{};
    }

    void eliminar(int index) override {
        if (index < 0 || index >= cantidad) return;
        if (index == 0) {
            Nodo* borrar = cabeza;
            cabeza = cabeza->sig;
            delete borrar;
        } else {
            Nodo* aux = cabeza;
            for (int i = 0; i < index - 1; i++)
                aux = aux->sig;
            Nodo* borrar = aux->sig;
            aux->sig = borrar->sig;
            delete borrar;
        }
        cantidad--;
    }

    int tam() const override {
        return cantidad;
    }

    ~ListaEnlazada() {
        while (cabeza) {
            Nodo* temp = cabeza;
            cabeza = cabeza->sig;
            delete temp;
        }
    }
};

int main() {
    unique_ptr<Lista> lista1 = make_unique<ListaArray>();
    unique_ptr<Lista> lista2 = make_unique<ListaEnlazada>();

    lista1->agregar(string("Hola"));
    lista1->agregar(42);
    lista1->agregar(3.14);

    lista2->agregar(string("Mundo"));
    lista2->agregar(false);
    lista2->agregar(99);

    cout << "ListaArray:\n";
    for (int i = 0; i < lista1->tam(); i++) {
        any elem = lista1->obtener(i);
        if (elem.type() == typeid(int))
            cout << any_cast<int>(elem);
        else if (elem.type() == typeid(double))
            cout << any_cast<double>(elem);
        else if (elem.type() == typeid(string))
            cout << any_cast<string>(elem);
        else if (elem.type() == typeid(bool))
            cout << (any_cast<bool>(elem) ? "true" : "false");
        cout << endl;
    }

    cout << "\nListaEnlazada:\n";
    for (int i = 0; i < lista2->tam(); i++) {
        any elem = lista2->obtener(i);
        if (elem.type() == typeid(int))
            cout << any_cast<int>(elem);
        else if (elem.type() == typeid(string))
            cout << any_cast<string>(elem);
        else if (elem.type() == typeid(bool))
            cout << (any_cast<bool>(elem) ? "true" : "false");
        cout << endl;
    }

    return 0;
}
