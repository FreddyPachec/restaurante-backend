package pe.proyecto.restaurante.service;

import java.util.Collection;

import pe.proyecto.restaurante.model.Almacen;

public interface AlmacenService {
	public abstract void insert(Almacen almacen);
	public abstract void update(Almacen almacen);
	public abstract void delete(Integer almacen_id);
	public abstract Almacen findById(Integer almacen_id);
	public abstract Collection<Almacen> findAll();
}
