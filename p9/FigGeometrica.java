
public class FigGeometrica {
    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado(2);
        Rectangulo r1 = new Rectangulo(2,4);

        System.out.println("area c1: " + c1.obtenerArea());
        System.out.println("perimetro c1: " + c1.obtenerPerimetro());

        System.out.println("area r1: " + r1.obtenerArea());
        System.out.println("perimetro r1: " + r1.obtenerPerimetro());
    }
}
