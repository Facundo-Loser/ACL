#include <stdio.h>

unsigned int n;

int es_perfecto(int n); // retorna true si n es perfecto, false cc

int main(void) {
    printf("Enter n: ");
    scanf("%d", &n);
    printf("%d es perfecto?: %d\n", n, es_perfecto(n));
    return 0;
}

int es_perfecto(int n) {
    int acum = 0;
    for (int i=1; i<n; i++) {
        if ((n%i)==0) acum += i;
    }
    return (n== acum);
}
