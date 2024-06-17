package junio;

public abstract class Empleado {
    protected String nombre;
    protected int matricula;
    protected static int siguienteMatricula = 1;
    protected int proyectosAsignados = 0;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.matricula = siguienteMatricula++;
    }

    public abstract double calcularSalario(int diasTrabajados);

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProyectosAsignados() {
        return proyectosAsignados;
    }

    public abstract void incrementarProyectos() throws DemasiadosProyectosException;

	protected static void add(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	protected abstract String getMatrícula();
}
