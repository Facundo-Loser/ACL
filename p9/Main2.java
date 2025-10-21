
class A {
    public A() {}

    public void m1() {
        System.out.println("AAAA");
    }
}

class B extends A {
    public B() {}
    
    public void m1() {
        System.out.println("BBBB");
    }
}

class C extends B {
    public C() {}
    
    public void m1() {
        super.m1();
    }
}

public class Main2 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
    }
}

// si uso final en un mètodo no lo permite redefinir en una clase que herede (PROBAR)
