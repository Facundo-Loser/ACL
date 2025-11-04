public class Semaphore {
    private int sem;

    public Semaphore(int init_value) { sem = init_value; }

    public synchronized void P() {
        while (sem == 0) {
            try { wait(); } catch(InterruptedException e) { ; }
        }
        sem--;
    }

    public synchronized void V() {
        sem++;
        //notify();
        notifyAll();
    }
}


/*
 Cuando un thread entra en un bloque o método synchronized, obtiene
 un lock implícito (monitor) asociado al objeto o a la clase.
 */
