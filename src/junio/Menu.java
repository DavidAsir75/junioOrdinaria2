package junio;

import java.util.Scanner;
import java.util.Date;

public class Menu {
    private Gestor gestor;
    private Scanner scanner;

    public Menu() {
        this.gestor = new Gestor();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir proyecto");
            System.out.println("2. Borrar proyecto");
            System.out.println("3. Listado de proyectos");
            System.out.println("4. Informe de proyectos");
            System.out.println("5. Salir");
            System.out.print("Introduzca opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (opcion) {
                case 1:
                    addProyecto();
                    break;
                case 2:
                    removeProyecto();
                    break;
                case 3:
                    listadoProyectos();
                    break;
                case 4:
                    informeProyectos();
                    break;
                case 5:
                    gestor.guardarProyectos(); // Guardar proyectos antes de salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private void addProyecto() {
        System.out.print("Ingrese nombre del proyecto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese empresa del proyecto: ");
        String empresa = scanner.nextLine();
        gestor.addProyecto(nombre, empresa, new Date());
        System.out.println("Proyecto añadido exitosamente.");
    }

    private void removeProyecto() {
        System.out.print("Ingrese nombre del proyecto a eliminar: ");
        String nombre = scanner.nextLine();
        gestor.removeProyecto(nombre);
        System.out.println("Proyecto eliminado exitosamente.");
    }

    private void listadoProyectos() {
        System.out.println("\nListado de proyectos:");
        for (Proyecto p : gestor.listarProyectos()) {
            System.out.println(p);
        }
    }

    private void informeProyectos() {
        System.out.println("\nInforme de proyectos por empresa:");
        gestor.informeProyectos();
    }
}