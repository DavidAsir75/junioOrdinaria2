package junio;

public class Examen {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Menu menu = new Menu(gestor);
        menu.mostrarMenu();
    }
}
