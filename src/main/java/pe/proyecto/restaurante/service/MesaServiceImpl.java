package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Mesa;
import pe.proyecto.restaurante.repository.MesaRepository;

@Service
public class MesaServiceImpl implements MesaService  {
	
	@Autowired
	private MesaRepository repository;

	@Override
	@Transactional
	public void insert(Mesa mesa) {
		repository.save(mesa);
	}

	@Override
	@Transactional
	public void update(Mesa mesa) {
		repository.save(mesa);		
	}

	@Override
	@Transactional
	public void delete(Integer mesa_id) {
		repository.deleteById(mesa_id);		
	}

	@Override
	@Transactional
	public Mesa findById(Integer mesa_id) {
		return repository.findById(mesa_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Mesa> findAll() {
		return (Collection<Mesa>)repository.findAll();
	}

}
