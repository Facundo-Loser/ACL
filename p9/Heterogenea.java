// clase abstracta
abstract class Lista {
    public abstract void addElem(Object elem);
    public abstract void modElem(Object elem, int pos);
    public abstract Object eliminarElem(int pos);
    public abstract int getSize();
    public abstract boolean isEmpty();
    public abstract String toString();
}

// implementación con array
class ArrayLista extends Lista {
    private Object[] elems;
    private int cant;

    public ArrayLista() {
        elems = new Object[20];
        cant = 0;
    }

    public void addElem(Object elem) {
        if (cant == 20) {
            System.out.println("[ERROR]: ArrayList is full!");
            return;
        }
        elems[cant++] = elem;
    }

    public void modElem(Object elem, int pos) {
        if ((pos > (cant-1)) || (pos < 0)) {
            System.out.println("[ERROR]: index out of range!");
            return;
        }
        elems[pos] = elem;
    }

    public Object eliminarElem(int pos) {
        if ((pos > (cant-1)) || (pos < 0)) {
            System.out.println("[ERROR]: index out of range!");
            return null;
        }
        if (cant==0) {
            System.out.println("[ERROR]: arrayLista empty!");
            return null;
        }
        Object removed = elems[pos];
        for (int i = pos; i < (cant-1); i++) {
            elems[i] = elems[i+1];
        }
        cant--;
        return removed;
    }

    public int getSize() {
        return cant;
    }

    public boolean isEmpty() {
        return (cant==0);
    }

    public String toString() {
        String res = "[";
        for (int i = 0; i < cant; i++) {
            res+= elems[i].toString() + ",";
        }
        return res+"]";
    }
}


// Nodo
class Node {
    private Object elem;
    private Node next;

    public Node(Object elem) {
        this.elem = elem;
        this.next = null;
    }

    public void modNode(Object elem) {
        this.elem = elem;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Object getElem() {
        return elem;
    }
}


// implementación con lista enlazada
class ListaEnlazada extends Lista {
    private Node first;
    private Node last;
    private int cant;

    public ListaEnlazada() {
        first = null;
        last = null;
        cant = 0;
    }

    public void addElem(Object elem) {
        if (first==null) {
            first = new Node(elem);
            last = first;
        } else {
            Node aux = new Node(elem);
            last.setNext(aux);
            last = last.getNext();
        }
        cant++;
    }

    public void modElem(Object elem, int pos) {
        if ((pos < 0) || (pos > (cant-1))) {
            System.out.println("[ERROR]; index out of range");
            return;
        }
        Node aux = first;
        for (int i = 0; i <= pos; i++) {
            aux = aux.getNext();
        }
        aux.modNode(elem);
    }

    public Object eliminarElem(int pos) {
        if ((pos < 0) || (pos > (cant-1))) {
            System.out.println("[ERROR]: index out of range");
            return null;
        }
        if (first==null) {
            System.out.println("[ERROR]: empty linked list");
            return null;
        }
        if (pos==0) {
            first = first.getNext();
        }
        Node aux = first;
        for (int i=0; i < pos; i++) {
            aux = aux.getNext();
        }
        Node removed = aux.getNext();
        aux.setNext(aux.getNext().getNext());
        return removed;
    }

    public int getSize() {
        return cant;
    }

    public boolean isEmpty() {
        return (cant==0);
    }

    public String toString() {
        String res="[";
        Node aux = first;
        for (int i = 0; i < cant; i++) {
            res += aux.getElem().toString() + ",";
            aux = aux.getNext();
        }
        return res + "]";
    }
}

// Main
class Heterogenea {
    public static void main(String[] args) {
        // ArrayLista
        Lista l1 = new ArrayLista();
        l1.addElem(1);
        l1.addElem(2);
        l1.addElem("a");
        l1.addElem("b");
        System.out.println(l1.toString());

        // Lista Enlazada
        Lista l2 = new ListaEnlazada();
        l2.addElem(3);
        l2.addElem(4);
        l2.addElem("c");
        l2.addElem("d");
        System.out.println(l2.toString());
    }
}
