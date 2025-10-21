class A {

    public A() {}

    public void m1() {
        System.out.println("AAAA");
    }

    public void m() {
        this.m1();
    }
}

class B extends A {
        
    public B() {}

    public void m1() {
        System.out.println("BBBB");
    }
}

public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.m();
    }
}
