package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Empleado;
import pe.proyecto.restaurante.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository repository;

	@Override
	@Transactional
	public void insert(Empleado empleado) {
		repository.save(empleado);
	}

	@Override
	@Transactional
	public void update(Empleado empleado) {
		repository.save(empleado);		
	}

	@Override
	@Transactional
	public void delete(Integer empleado_id) {
		repository.deleteById(empleado_id);		
	}

	@Override
	@Transactional
	public Empleado findById(Integer empleado_id) {
		return repository.findById(empleado_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Empleado> findAll() {
		return (Collection<Empleado>)repository.findAll();
	}

}
