package pe.proyecto.restaurante.repository;

import org.springframework.data.repository.CrudRepository;

import pe.proyecto.restaurante.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
