package junio;

import java.util.ArrayList;
import java.io.*;

public class Fichero {
    private static final String FILE_NAME = "proyectos.dat";

    // Método para guardar la lista de proyectos en un archivo
    public static void guardar(ArrayList<Proyecto> proyectos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(proyectos);
            System.out.println("Proyectos guardados correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al guardar proyectos: " + e.getMessage());
        }
    }

    // Método para cargar la lista de proyectos desde un archivo
    public static ArrayList<Proyecto> cargar() {
        File archivo = new File(FILE_NAME);
        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado. Se iniciará con una lista nueva de proyectos.");
            return new ArrayList<>();  // Si no existe el archivo, retorna una lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Proyecto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar proyectos: " + e.getMessage());
            return new ArrayList<>();  // Si hay un error, retorna una lista vacía
        }
    }
}