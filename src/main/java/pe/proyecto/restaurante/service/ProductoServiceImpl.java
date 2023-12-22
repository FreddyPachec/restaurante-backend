package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Producto;
import pe.proyecto.restaurante.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	@Transactional
	public void insert(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional
	public void update(Producto producto) {
		repository.save(producto);		
	}

	@Override
	@Transactional
	public void delete(Integer producto_id) {
		repository.deleteById(producto_id);		
	}

	@Override
	@Transactional
	public Producto findById(Integer producto_id) {
		return repository.findById(producto_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Producto> findAll() {
		return (Collection<Producto>)repository.findAll();
	}	

}
