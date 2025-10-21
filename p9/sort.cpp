#include <iostream>
#include <algorithm>  // std::sort
#include <vector>
#include <functional> // std::greater
#include <cstdlib>    // std::atoi

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cout << "Uso: " << argv[0] << " num1 num2 num3 ..." << std::endl;
        return 1;
    }

    std::vector<int> numeros;

    // Convertimos los argumentos a enteros y los agregamos al vector
    for (int i = 1; i < argc; ++i) {
        numeros.push_back(std::atoi(argv[i]));
    }

    // Ordenamos de menor a mayor usando std::sort y std::less<int>
    std::sort(numeros.begin(), numeros.end(), std::less<int>());

    std::cout << "Orden ascendente: ";
    for (int n : numeros) {
        std::cout << n << " ";
    }
    std::cout << std::endl;

    // Ordenamos de mayor a menor usando std::greater<int>
    std::sort(numeros.begin(), numeros.end(), std::greater<int>());

    std::cout << "Orden descendente: ";
    for (int n : numeros) {
        std::cout << n << " ";
    }
    std::cout << std::endl;

    return 0;
}

/*
facu@Facundo:~/ACL/p9$ ./sort 2 4 3 6 5 1
Orden ascendente: 1 2 3 4 5 6
Orden descendente: 6 5 4 3 2 1



std::less<int>() -> objeto función
greater<int>()   -> objeto función

template <class T>
struct less {
    bool operator()(const T& a, const T& b) const {
        return a < b;
    }
};

template <class T>
struct greater {
    bool operator()(const T& a, const T& b) const {
        return a > b;
    }
};

*/
