package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.DetallePedido;

public interface DetallePedidoService {
	public abstract void insert(DetallePedido detallePedido);
	public abstract void update(DetallePedido detallePedido);
	public abstract void delete(Integer detallePedido_id);
	public abstract DetallePedido findById(Integer detallePedido_id);
	public abstract Collection<DetallePedido> findAll();
}
