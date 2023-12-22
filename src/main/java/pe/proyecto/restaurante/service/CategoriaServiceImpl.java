package pe.proyecto.restaurante.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import pe.proyecto.restaurante.model.Categoria;
import pe.proyecto.restaurante.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	@Transactional
	public void insert(Categoria categoria) {
		repository.save(categoria);
	}

	@Override
	@Transactional
	public void update(Categoria categoria) {
		repository.save(categoria);		
	}

	@Override
	@Transactional
	public void delete(Integer categoria_id) {
		repository.deleteById(categoria_id);		
	}

	@Override
	@Transactional
	public Categoria findById(Integer categoria_id) {
		return repository.findById(categoria_id).orElse(null);
	}

	@Override
	@Transactional
	public Collection<Categoria> findAll() {
		return (Collection<Categoria>)repository.findAll();
	}

}
