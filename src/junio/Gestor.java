package junio;

import java.util.HashMap;
import java.util.Map;

public class Gestor {
    private Map<String, Proyecto> proyectos;

    public Gestor() {
        this.proyectos = Fichero.cargarProyectos(); // Carga los proyectos al iniciar
    }

    public void agregarProyecto(Proyecto proyecto) throws Exception {
        if (proyectos.containsKey(proyecto.getNombre())) {
            throw new Exception("Proyecto duplicado.");
        }
        proyectos.put(proyecto.getNombre(), proyecto);
        Fichero.guardarProyectos(proyectos);  // Guarda cada vez que se agrega un proyecto
    }

    public void eliminarProyecto(String nombre) {
        if (proyectos.containsKey(nombre)) {
            proyectos.remove(nombre);
            Fichero.guardarProyectos(proyectos);  // Guarda cada vez que se elimina un proyecto
        }
    }

    public Proyecto obtenerProyecto(String nombre) {
        return proyectos.get(nombre);
    }

    public Map<String, Proyecto> obtenerTodosProyectos() {
        return new HashMap<>(proyectos);
    }
}