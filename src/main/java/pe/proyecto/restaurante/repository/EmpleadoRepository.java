package pe.proyecto.restaurante.repository;

import org.springframework.data.repository.CrudRepository;

import pe.proyecto.restaurante.model.Empleado;

public interface EmpleadoRepository  extends CrudRepository<Empleado, Integer> {

}
