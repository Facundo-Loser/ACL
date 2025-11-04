class Buffer {
    int[] buf; // buffer (cola circular)
    int first; // indice del primer elem         [para get()]
    int last;  // indice del proximo lugar libre [para put()]
    int n;     // cap total del buffer
    int i;     // cantde elmentos actualmente en el buffer
    Semaphore full;
    Semaphore mutex;
    Semaphore empty;

    public void init(int size) {
        buf=new int[size];
        n=size; i=0; first=0; last=0;
        full = new Semaphore(size);
        mutex = new Semaphore(1);
        empty = new Semaphore(0);
    }

    public void put(int x) {
        full.P(); // intento ocupar un lugar mas

        mutex.P(); // region critica lectura/escritura
        buf[last]=x;
        last=(last+1)%n;
        i=i+1;
        mutex.V();

        empty.V(); // despertar al consumidor (ahora hay almenos 1 elem ene l buffer)
    }

    public int get() {
        empty.P(); // intenta consumir en elem

        int x;
        mutex.P(); // region crítica
        x=buf[first];
        first=(first+1)%n;
        i=i-1;
        mutex.V();

        full.V(); // consumio un elem -> al al menos un lugar libre -> despierta al productor
        return x;
    }
}

class Producer implements Runnable {
    private Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 14; i++) {
            b.put(2);
            System.out.println("Producer added a new elem");
        }
    }
}

class Consumer implements Runnable {
    private Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 14; i++) {
            int x = b.get();
            System.out.println("Consumer consumed an elem: " + x);
        }
    }
}

public class Ej17 {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        b.init(10);
        Thread t1 = new Thread(new Producer(b));
        Thread t2 = new Thread(new Consumer(b));

        t1.start();
        t2.start();

        try {
            t1.join(); // Espera a que termine el hilo t1
            t2.join(); // Espera a que termine el hilo t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}