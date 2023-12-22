package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Cliente;

public interface ClienteService {
	public abstract void insert(Cliente cliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer cliente_id);
	public abstract Cliente findById(Integer cliente_id);
	public abstract Collection<Cliente> findAll();
}
