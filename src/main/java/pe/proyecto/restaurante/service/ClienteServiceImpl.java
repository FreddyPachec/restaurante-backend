package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Cliente;
import pe.proyecto.restaurante.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	@Transactional
	public void insert(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		repository.save(cliente);		
	}

	@Override
	@Transactional
	public void delete(Integer cliente_id) {
		repository.deleteById(cliente_id);		
	}

	@Override
	@Transactional
	public Cliente findById(Integer cliente_id) {
		return repository.findById(cliente_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Cliente> findAll() {
		return (Collection<Cliente>)repository.findAll();
	}

}
