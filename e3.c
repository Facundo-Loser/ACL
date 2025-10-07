#include <stdio.h>
#include <stdlib.h>

// aclaración: max número que permite ingresar es 999999

void obtener_cifras(int n, int cifras[6]);
int es_capicua(int n);

int cifras[6];
int n = 932239;
int k = 961800;

int main(void) {
    obtener_cifras(n, cifras);
    for (int i = 0; i < 6; i++){
        printf("cifra %d: %d\n", i, cifras[i]);
    }
    printf("es capicua %d?: %d\n", n, es_capicua(n));
    printf("es capicua %d?: %d\n", k, es_capicua(k));
    return 0;
}

void obtener_cifras(int n, int cifras[6]) {
    int j = 0;
    for (int i = 100000; i>=1; i/=10) {
        cifras[j] = (n/i) % 10;
        j++;
    }
}

int es_capicua(int n) {
    int cifras[6];
    obtener_cifras(n, cifras);
    for (int i=0; i<=2; i++) {
        if (cifras[i] != cifras[5-i]) return 0;
    }
    return 1;
}
