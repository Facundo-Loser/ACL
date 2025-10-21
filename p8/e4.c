#include <stdio.h>
#include <math.h>

double tolerancia = 1e-6;
double a = 0;
double b = 3;
double max_iter = 100;

double f(double x);
double obtener_raiz(double (*f)(double), double a, double b, double tolerancia, int max_iter);

int main(void) {
    double raiz = obtener_raiz(f, a, b, tolerancia, max_iter);
    if (raiz != -1) {
        printf("Raíz aproximada: %.6f\n", raiz);
    }
    return 0;
}

double f(double x) { return x*x-1; } // x^2-4 (ejemplo)

double obtener_raiz(double (*f)(double), double a, double b, double tolerancia, int max_iter) {
    if (f(a) * f(b) >= 0) {
        printf("La función no cambia de signo en el intervalo [%f, %f]\n", a, b);
        return -1;  // error
    }

    double m;  // Punto medio
    for (int i = 0; i < max_iter; i++) {
        m = (a + b) / 2;  // calcula el punto medio

        if (fabs(f(m)) < tolerancia) {
            return m;  // raíz aprox
        }

        // determinar en qué subintervalo continuar
        if (f(a) * f(m) < 0) {
            b = m;  // buscar en el intervalo [a, m]
        } else {
            a = m;  // buscar en el intervalo [m, b]
        }
    }

    printf("No se alcanzó la convergencia después de %d iteraciones.\n", max_iter);
    return m;  // retorna la mejor aproximación obtenida
}
