package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Categoria;

public interface CategoriaService {
	public abstract void insert(Categoria categoria);
	public abstract void update(Categoria categoria);
	public abstract void delete(Integer categoria_id);
	public abstract Categoria findById(Integer categoria_id);
	public abstract Collection<Categoria> findAll();
}
