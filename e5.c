#include <stdio.h>
#include <math.h>

#define P 3
#define Q 3

int matrix[P][Q] = {
    {1, 2, 3},
    {4, 6, 8},
    {1, 1, 1}
};

int sum_fila(int* f);
int* max_fila(int matrix[P][Q]);

int* max_fila_p;

int main(void) {
    max_fila_p = max_fila(matrix);
    // printeamos la fila de suma maxima para chequear
    printf("[ ");
    for (int i = 0; i < Q; i++) {
        printf("%d ", max_fila_p[i]);
    }
    printf("]\n");
    return 0;
}

int sum_fila(int* f) {
    int acum = 0;
    for (int i = 0; i < Q; i++) acum+=f[i];
    return acum;
}

int* max_fila(int matrix[P][Q]) {
    int* max_fila_p;
    int suma_actual = -INFINITY;
    for (int i = 0; i < P; i++) {
        int suma = sum_fila(matrix[i]);
        if (suma_actual < suma) {
            max_fila_p = matrix[i];
            suma_actual = suma;
        }
    }
    return max_fila_p;
}
