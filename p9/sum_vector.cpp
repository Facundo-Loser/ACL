#include <iostream>
#include <vector>
#include <numeric> // para std::accumulate
using namespace std;

int main() {
    // Creamos un vector de enteros
    vector<int> numeros = {1, 2, 3, 4, 5};

    // Suma de los elementos usando accumulate
    int suma = accumulate(numeros.begin(), numeros.end(), 0);

    // Producto de los elementos usando accumulate con una lambda
    int producto = accumulate(numeros.begin(), numeros.end(), 1,
                              [](int a, int b) { return a * b; });

    cout << "Suma: " << suma << endl;
    cout << "Producto: " << producto << endl;

    return 0;
}
