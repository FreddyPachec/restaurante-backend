package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Venta;
import pe.proyecto.restaurante.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService  {
	
	@Autowired
	private VentaRepository repository;

	@Override
	@Transactional
	public void insert(Venta venta) {
		repository.save(venta);
	}

	@Override
	@Transactional
	public void update(Venta venta) {
		repository.save(venta);		
	}

	@Override
	@Transactional
	public void delete(Integer venta_id) {
		repository.deleteById(venta_id);		
	}

	@Override
	@Transactional
	public Venta findById(Integer venta_id) {
		return repository.findById(venta_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Venta> findAll() {
		return (Collection<Venta>)repository.findAll();
	}

}
