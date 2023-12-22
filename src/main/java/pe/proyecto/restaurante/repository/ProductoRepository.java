package pe.proyecto.restaurante.repository;

import org.springframework.data.repository.CrudRepository;

import pe.proyecto.restaurante.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}