#include <stdio.h>

#define P 3
#define Q 3

int matrix[P][Q] = {
    {1, 2, 3},
    {4, 6, 8},
    {1, 1, 1}
};

int sum_fila(int* matrix, int i);
void sum_filas(int* matrix, int* A);

int vector[P];

int main(void) {
    sum_filas(matrix, vector);
    printf("[ ");
    for (int i = 0; i < P; i++) {
        printf("%d ", vector[i]);
    }
    printf("]\n");
    return 0;
}

// retorna la suma de la i-esima fila
int sum_fila(int* matrix, int i) {
    int acum = 0;
    for (int j = 0; j < Q; j++) {
        acum += *(matrix + i * Q + j);
    }
    return acum;
}

void sum_filas(int* matrix, int* A) {
    for (int i = 0; i < P; i++) {
        *(A + i) = sum_fila(matrix, i);
    }
}
