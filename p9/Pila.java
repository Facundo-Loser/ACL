public class Pila<T> {
    private T[] elems;
    private int cantElems;
    private int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.cantElems = 0;
        this.elems = (T[]) new Object[capacidad];
    }

    public void push(T elem) {
        if (cantElems > capacidad) {
            System.out.println("[ERROR]: the stack is full!");
            elems[cantElems++] = elem;
        }
        elems[cantElems++] = elem;
    }

    public T pop() {
        if (cantElems == 0) {
            System.out.println("[ERROR]: the stack is empty!");
            return null;
        }
        cantElems--;
        return elems[cantElems];
    }

    public String toString() {
        if (cantElems == 0) return "[]";
        String res = "";
        for(int i = cantElems-1; i >= 0; i--) {
            //System.out.println("i: " + i);
            res += "[" + elems[i].toString() + "]\n";
        }
        return res;
    }

    public static void main(String[] args) {
        Pila<Integer> p1 = new Pila<>(20);
        p1.push(1);
        p1.push(2);
        p1.push(3);
        p1.push(4);
        System.out.println(p1.toString());
        p1.pop();
        p1.pop();
        System.out.println(p1.toString());
    }
}
