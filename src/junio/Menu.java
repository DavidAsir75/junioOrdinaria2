package junio;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Gestor gestor;
    private Scanner scanner;

    public Menu(Gestor gestor) {
        this.gestor = gestor;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Añadir proyecto");
            System.out.println("2. Borrar proyecto");
            System.out.println("3. Listar proyectos");
            System.out.println("4. Mostrar información de un proyecto");
            System.out.println("5. Salir");
            System.out.print("Introduce una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (opcion) {
                case 1:
                    agregarProyecto();
                    break;
                case 2:
                    borrarProyecto();
                    break;
                case 3:
                    listarProyectos();
                    break;
                case 4:
                    mostrarInformacionProyecto();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private void agregarProyecto() {
        System.out.println("Introduce el nombre del proyecto:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el cliente del proyecto:");
        String cliente = scanner.nextLine();
        Fecha fechaInicio = new Fecha(); // Assume Fecha class exists

        try {
            Proyecto nuevoProyecto = new Proyecto(nombre, cliente, fechaInicio);
            gestor.agregarProyecto(nuevoProyecto);
            System.out.println("Proyecto agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el proyecto: " + e.getMessage());
        }
    }

    private void borrarProyecto() {
        System.out.println("Introduce el nombre del proyecto a borrar:");
        String nombre = scanner.nextLine();
        Proyecto proyecto = gestor.obtenerProyecto(nombre);
        if (proyecto != null) {
            gestor.eliminarProyecto(nombre);
            System.out.println("Proyecto eliminado.");
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    private void listarProyectos() {
        Map<String, Proyecto> proyectos = gestor.obtenerTodosProyectos();
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos disponibles.");
        } else {
            for (Proyecto proyecto : proyectos.values()) {
                System.out.println("Nombre del Proyecto: " + proyecto.getNombre() + ", Cliente: " + proyecto.getCliente());
            }
        }
    }

    private void mostrarInformacionProyecto() {
        System.out.println("Introduce el nombre del proyecto para mostrar información:");
        String nombre = scanner.nextLine();
        Proyecto proyecto = gestor.obtenerProyecto(nombre);
        if (proyecto != null) {
            System.out.println("Nombre del Proyecto: " + proyecto.getNombre());
            System.out.println("Cliente del Proyecto: " + proyecto.getCliente());
            System.out.println("Empleados asignados:");
            for (Empleado empleado : proyecto.getEmpleados()) {
                System.out.println("Empleado: " + empleado.getNombre() + ", Matrícula: " + empleado.getMatrícula());
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }
}}