package junio;

public abstract class Programador extends Empleado {
    private static final double SALARIO_DIARIO = 100;
    private static final int MAX_PROYECTOS_LIDER = 10;
    private boolean esLider;

    public Programador(String nombre, boolean esLider) {
        super(nombre);
        this.esLider = esLider;
    }

    @Override
    public double calcularSalario(int diasTrabajados) {
        double salario = diasTrabajados * SALARIO_DIARIO;
        if (esLider) {
            salario *= 1.25; // Un incremento del 25% para los líderes
        }
        return salario;
    }

    @Override
    public void incrementarProyectos() throws DemasiadosProyectosException {
        if (esLider && proyectosAsignados >= MAX_PROYECTOS_LIDER) {
            throw new DemasiadosProyectosException("Este líder de programadores ya está asignado al máximo de proyectos permitidos.");
        }
        proyectosAsignados++;
    }

    public boolean esLider() {
        return esLider;
    }

    public void setLider(boolean esLider) {
        this.esLider = esLider;
    }
}
