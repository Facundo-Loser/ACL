// 9) Dé un ejemplo de una función en Java con número de parámetros variable

public class Ej9 {

    public static void printMsj(String... nombres) {
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {
        String[] msjs = {"Juan", "Pedro", "Carlos", "Facu"};
        printMsj(msjs);
    }
}
