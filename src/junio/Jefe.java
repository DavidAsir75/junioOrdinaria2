package junio;

public abstract class Jefe extends Empleado {
    private static final double SALARIO_DIARIO = 150;
    private static final int MAX_PROYECTOS = 3;

    public Jefe(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularSalario(int diasTrabajados) {
        return diasTrabajados * SALARIO_DIARIO;
    }

    @Override
    public void incrementarProyectos() throws DemasiadosProyectosException {
        if (proyectosAsignados >= MAX_PROYECTOS) {
            throw new DemasiadosProyectosException("Jefe asignado a demasiados proyectos.");
        }
        proyectosAsignados++;
    }
}
