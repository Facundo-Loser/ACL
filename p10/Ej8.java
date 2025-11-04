
class Cuenta {
    private int saldo;

    public Cuenta(int saldoInicial) {
        saldo = saldoInicial;
    }

    public void deposita(int monto) {
        saldo += monto;
    }

    public void retira(int monto) {
        saldo -= monto;
    }
    public int getSaldo() { return saldo; }
}

public class Ej8 implements Runnable {
    private Cuenta c;
    private boolean accion;

    public Ej8(Cuenta c, boolean accion) {
        this.c = c;
        this.accion = accion;
    }

    @Override
    public void run() {
        int montoActual;
        if (accion) {
            montoActual = c.getSaldo();
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            c.deposita(montoActual+10);
            c.retira(20);
        } else {
            c.retira(20);
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            montoActual = c.getSaldo();
            c.deposita(montoActual+10);
        }
    }

    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(100);
        Thread t1 = new Thread(new Ej8(c1, true));
        Thread t2 = new Thread(new Ej8(c1, false));
        t1.start();
        t2.start();
        try {
            t1.join(); // Espera a que termine el hilo t1
            t2.join(); // Espera a que termine el hilo t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("el saldo de c1 es: " + c1.getSaldo());
    }
}


/*
 si los threads se ejecutaran secuencialmente t1 y luego t2 el resultado debería ser 350, pero la salida obtenida es 190
*/
