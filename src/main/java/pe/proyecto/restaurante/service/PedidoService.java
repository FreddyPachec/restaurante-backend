package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Pedido;

public interface PedidoService {
	public abstract void insert(Pedido pedido);
	public abstract void update(Pedido pedido);
	public abstract void delete(Integer pedido_id);
	public abstract Pedido findById(Integer pedido_id);
	public abstract Collection<Pedido> findAll();
}
