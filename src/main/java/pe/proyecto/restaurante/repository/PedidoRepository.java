package pe.proyecto.restaurante.repository;

import org.springframework.data.repository.CrudRepository;

import pe.proyecto.restaurante.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
