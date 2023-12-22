package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Almacen;
import pe.proyecto.restaurante.repository.AlmacenRepository;

@Service
public class AlmacenServiceImpl implements AlmacenService {

	@Autowired
	private AlmacenRepository repository;

	@Override
	@Transactional
	public void insert(Almacen almacen) {
		repository.save(almacen);
	}

	@Override
	@Transactional
	public void update(Almacen almacen) {
		repository.save(almacen);		
	}

	@Override
	@Transactional
	public void delete(Integer almacen_id) {
		repository.deleteById(almacen_id);		
	}

	@Override
	@Transactional
	public Almacen findById(Integer almacen_id) {
		return repository.findById(almacen_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Almacen> findAll() {
		return (Collection<Almacen>)repository.findAll();
	}

}
