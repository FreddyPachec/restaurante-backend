package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Producto;

public interface ProductoService {
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer producto_id);
	public abstract Producto findById(Integer producto_id);
	public abstract Collection<Producto> findAll();
}
