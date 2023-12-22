package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Mesa;

public interface MesaService {
	public abstract void insert(Mesa mesa);
	public abstract void update(Mesa mesa);
	public abstract void delete(Integer mesa_id);
	public abstract Mesa findById(Integer mesa_id);
	public abstract Collection<Mesa> findAll();
}
