public class Rectangulo extends Figura {
    private float lado1;
    private float lado2;

    public Rectangulo(float lado1, float lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public float obtenerPerimetro() {
        return (2*lado1)+(2*lado2);
    }

    @Override
    public float obtenerArea() {
        return lado1*lado2;
    }
}
