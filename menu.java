import java.util.Scanner;
import java.util.Date;

public class Menu {
    private GestorProyectos gestorProyectos;
    private Scanner scanner;

    public Menu() {
        this.gestorProyectos = new GestorProyectos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
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
                    gestorProyectos.guardarProyectos(); // Guardar proyectos antes de salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Añadir proyecto");
        System.out.println("2. Borrar proyecto");
        System.out.println("3. Listado de proyectos");
        System.out.println("4. Informe de proyectos");
        System.out.println("5. Salir");
    }

    private void addProyecto() {
        System.out.print("Ingrese nombre del proyecto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese empresa del proyecto: ");
        String empresa = scanner.nextLine();
        gestorProyectos.addProyecto(nombre, empresa, new Date());
        System.out.println("Proyecto añadido exitosamente.");
    }

    private void removeProyecto() {
        System.out.print("Ingrese nombre del proyecto a eliminar: ");
        String nombre = scanner.nextLine();
        gestorProyectos.removeProyecto(nombre);
        System.out.println("Proyecto eliminado exitosamente.");
    }

    private void listadoProyectos() {
        System.out.println("\nListado de proyectos:");
        gestorProyectos.getProyectos().forEach(System.out::println);
    }

    private void informeProyectos() {
        System.out.println("\nInforme de proyectos por empresa:");
        gestorProyectos.getProyectos().stream()
            .sorted((p1, p2) -> p1.getEmpresa().compareTo(p2.getEmpresa()))
            .forEach(p -> System.out.println("Empresa: " + p.getEmpresa() + ", Proyecto: " + p.getNombre()));
    }
}
