#include <stdio.h>
#include <unistd.h> /* por getpid() */
#define N (2000)

int main(void) {
    FILE * f ;
    int i, value;
    for (i=0; i<N; i++) {
        f = fopen("seqno.txt","r+");
        int fd = fileno(f); // file descriptor o algo asi
        lockf(fd,F_LOCK,0);  // lock (bloqueo)
        fscanf(f,"%d", &value);
        value++;
        rewind(f);
        fprintf(f,"%6d\n", value);
        fflush(f);
        printf("Process id: %d, value: %d\n", getpid(), value);
        fflush(stdout); /* forzar la escritura al archivo */
        lockf(fd,F_ULOCK,0); // desbloqueo
        fclose(f);
        // sleep(2);
    }
}

// -> primero crear a mano el archivo seqno.txt y escribir un número

// b) ./main ; ./main

// c) ./main & ./main

// d) arranca seqno.txt con 1:
//    1ra corrida:   3062
//    2da corrrida:   3020
// rta: si hay race condition
