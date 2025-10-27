
class A2 {
    String m1 (A2 x) { return "AA2" ; }
    String m2 (A2 x) { return "Paso por A - m2(A2) "+ this.m1(x) ; }
}

public class B extends A2 {
    String m1 (B x) { return "BA2" ; }
    String m2 (B x) { return "Paso por B - m2(B) "+ this.m1(x) ; }
    String m2 (A2 x) { return "Paso por B - m2(A2) "+ this.m1(this) ; }

    public static void main(String[] args) {
        A2 a = new A2();
        A2 b2 = new B();
        B b3 = new B();
        System.out.println (a.m2 (b3));     // (1)
        System.out.println (b2.m2 (b2));    // (2)
        System.out.println (b3.m2 ((B)b2)); // (3)
        System.out.println (b3.m2 (a));     // (4)
    }
}

/*
 Compilación	Mira los tipos declarados de las variables (A2 a, A2 b2, B b3) y decide qué método se invoca (qué firma).
Ejecución	Usa el tipo real del objeto (new A2() o new B()) para decidir qué versión del método ejecutar (override).
Casteo	Afecta solo la compilación, cambiando el tipo declarado que se ve en ese punto. Pero no cambia el tipo real del objeto.
 */


 /*
Idea central:
En Java hay dos "tipos" distintos que conviven al mismo tiempo:
- El tipo estático (o de compilación) → lo que el compilador cree que es el objeto (por ejemplo, A, B o C según la variable o el cast).
- El tipo dinámico (o real) → el tipo real del objeto en memoria (por ejemplo, si fue creado con new C()).
-> El tipo estático decide qué método se puede llamar (qué firma es válida).
-> El tipo dinámico decide qué implementación se ejecuta.
 */
