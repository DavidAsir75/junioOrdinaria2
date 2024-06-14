package junio;

import java.util.ArrayList;
import java.util.Date;

public class Gestor {
    private ArrayList<Proyecto> proyectos;

    public Gestor() {
        this.proyectos = Fichero.cargar(); // Cargar proyectos desde el archivo
    }

    public void addProyecto(String nombre, String empresa, Date fechaInicio) {
        Proyecto nuevoProyecto = new Proyecto(nombre, empresa, fechaInicio);
        proyectos.add(nuevoProyecto);
        Fichero.guardar(proyectos);
    }

    public void removeProyecto(String nombre) {
        for (int i = 0; i < proyectos.size(); i++) {
            if (proyectos.get(i).getNombre().equals(nombre)) {
                proyectos.remove(i);
                break;
            }
        }
        Fichero.guardar(proyectos);
    }

    public ArrayList<Proyecto> listarProyectos() {
        return proyectos;
    }

    public void informeProyectos() {
        // Método para imprimir proyectos ordenados por empresa sin usar streams
        ArrayList<Proyecto> sortedProjects = new ArrayList<>(proyectos);
        sortedProjects.sort((p1, p2) -> p1.getEmpresa().compareTo(p2.getEmpresa()));
        for (Proyecto p : sortedProjects) {
            System.out.println("Empresa: " + p.getEmpresa() + ", Proyecto: " + p.getNombre());
        }
    }

    public void guardarProyectos() {
        Fichero.guardar(proyectos);
    }
}
