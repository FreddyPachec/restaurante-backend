package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.DetallePedido;
import pe.proyecto.restaurante.repository.DetallePedidoRepository;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
	
	@Autowired
	private DetallePedidoRepository repository;

	@Override
	@Transactional
	public void insert(DetallePedido detallePedido) {
		repository.save(detallePedido);
	}

	@Override
	@Transactional
	public void update(DetallePedido detallePedido) {
		repository.save(detallePedido);		
	}

	@Override
	@Transactional
	public void delete(Integer detallePedido_id) {
		repository.deleteById(detallePedido_id);		
	}

	@Override
	@Transactional
	public DetallePedido findById(Integer detallePedido_id) {
		return repository.findById(detallePedido_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<DetallePedido> findAll() {
		return (Collection<DetallePedido>)repository.findAll();
	}

}
