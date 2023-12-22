package pe.proyecto.restaurante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Pedido;
import pe.proyecto.restaurante.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService  {
	
	@Autowired
	private PedidoRepository repository;

	@Override
	@Transactional
	public void insert(Pedido pedido) {
		repository.save(pedido);
	}

	@Override
	@Transactional
	public void update(Pedido pedido) {
		repository.save(pedido);		
	}

	@Override
	@Transactional
	public void delete(Integer pedido_id) {
		repository.deleteById(pedido_id);		
	}

	@Override
	@Transactional
	public Pedido findById(Integer pedido_id) {
		return repository.findById(pedido_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Pedido> findAll() {
		return (Collection<Pedido>)repository.findAll();
	}

}
