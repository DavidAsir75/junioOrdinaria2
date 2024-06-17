package junio;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Fichero {
    private static final String FILE_PATH = "proyectos.dat";

    public static void guardarProyectos(Map<String, Proyecto> proyectos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(proyectos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Proyecto> cargarProyectos() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Map<String, Proyecto>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }
}