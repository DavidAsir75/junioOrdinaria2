package junio;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private String cliente;
    private Fecha fechaInicio; // Assume Fecha clºexists
    private List<Empleado> empleados;

    public Proyecto(String nombre, String cliente, Fecha fechaInicio) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.setFechaInicio(fechaInicio);
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) throws DemasiadosProyectosException {
        empleado.incrementarProyectos();
        Empleado.add(empleado);
    }

    public String getCliente() {
        return cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

	public Fecha getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}