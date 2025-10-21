class A {
    public void type() {
        System.out.println("Soy A");
    }
    public void type(A _a) {
        _a.type();
    }
}

class B extends A {
    public void type(){
        System.out.println("Soy B");
    }
}

class C extends B {
    public void type() {
        System.out.println("Soy C");
    }
    public void type(B _b) {
        _b.type();
    }
}

class Test {
    public static void main(String[] args){
    A a = new A();
    B b= new B();
    B c = new C(); // variable de tipo B, pero objeto de tipo C
    a.type(b);
    b.type(a);
    b.type(b);
    c.type((A) c);
    c.type((C) c);
    }
}


/*
Idea central:
En Java hay dos "tipos" distintos que conviven al mismo tiempo:
- El tipo estático (o de compilación) → lo que el compilador cree que es el objeto (por ejemplo, A, B o C según la variable o el cast).
- El tipo dinámico (o real) → el tipo real del objeto en memoria (por ejemplo, si fue creado con new C()).
-> El tipo estático decide qué método se puede llamar (qué firma es válida).
-> El tipo dinámico decide qué implementación se ejecuta.
 */
