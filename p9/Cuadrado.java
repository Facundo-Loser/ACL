
public class Cuadrado extends Figura {
    private float lado;

    public Cuadrado(float lado) {
        this.lado = lado;
    }

    @Override
    public float obtenerPerimetro() {
        return 4*lado;
    }

    @Override
    public float obtenerArea() {
        return lado*lado;
    }
}