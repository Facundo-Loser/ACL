class Buffer {
    int[] buf; // buffer (cola circular)
    int first; // indice del primer elem         [para get()]
    int last;  // indice del proximo lugar libre [para put()]
    int n;     // cap total del buffer
    int i;     // cantde elmentos actualmente en el buffer

    public void init(int size) {
        buf=new int[size];
        n=size; i=0; first=0; last=0;
    }

    public synchronized void put(int x) {
        while (i==n) {
            try { wait(); } catch(InterruptedException e) { ; } // decia i<n (corregido)
        }
        buf[last]=x;
        last=(last+1)%n;
        i=i+1;
        notifyAll();
    }

    public synchronized int get() {
        int x;
        while (i==0) {
             try { wait(); } catch(InterruptedException e) { ; }
        }
        x=buf[first];
        first=(first+1)%n;
        i=i-1;
        notifyAll();
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

public class Ej15 {
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

/*
 Salida:
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Producer added a new elem
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Producer added a new elem
Producer added a new elem
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Producer added a new elem
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
Consumer consumed an elem: 2
 */
