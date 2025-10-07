#include <stdio.h>
#include <stdlib.h>

char op;
int a, b,res;

int main(void) {
    printf("Enter a: ");
    scanf("%d", &a);
    printf("Enter b: ");
    scanf("%d", &b);
    printf("Enter the operation: ");
    scanf(" %c", &op);

    switch(op) {
        case '+': res = a+b; break;
        case '-': res = a-b; break;
        case '*': res = a*b; break;
        case '/': res = a/b; break;
        case '%': res = a%b; break;
        default:
            printf("[ERROR] invalid op: %c\n", op);
            exit(-1);
    }

    printf("operation: %d %c %d = %d\n", a, op, b, res);
    return 0;
}
