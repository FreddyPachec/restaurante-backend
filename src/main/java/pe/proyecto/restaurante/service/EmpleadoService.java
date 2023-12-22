package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Empleado;

public interface EmpleadoService {
	public abstract void insert(Empleado empleado);
	public abstract void update(Empleado empleado);
	public abstract void delete(Integer empleado_id);
	public abstract Empleado findById(Integer empleado_id);
	public abstract Collection<Empleado> findAll();
}
