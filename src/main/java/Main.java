
public class Main {
    public static void main(String[] args) {
        System.out.println("Hi !!!");

        GMatrix gMatrix = new GMatrix("4607011262302");

        System.out.println("Наименование: " + gMatrix.getName());
        System.out.println("Содержание: " + gMatrix.getComposition());
        System.out.println("Коммент: " + gMatrix.getComment());
    }
}
