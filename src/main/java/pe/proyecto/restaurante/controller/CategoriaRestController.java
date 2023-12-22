package pe.proyecto.restaurante.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.proyecto.restaurante.model.Categoria;
import pe.proyecto.restaurante.service.CategoriaService;

@RestController 
@RequestMapping("/categoria")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Categoria> itemsCategoria=categoriaService.findAll();		
		return new ResponseEntity<>(itemsCategoria,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{categoria_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer categoria_id)
	{
		Categoria categoriaDb=categoriaService.findById(categoria_id);
		
		if(categoriaDb!=null) {
			return new ResponseEntity<>(categoriaDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Categoria categoria)
	{
		categoriaService.insert(categoria);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{categoria_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer categoria_id,
                                        @RequestBody Categoria newCategoria)
	{		
		Categoria categoriaDb=categoriaService.findById(categoria_id);
		
		if(categoriaDb!=null)
		{
			categoriaDb.setNombre_categoria(newCategoria.getNombre_categoria());
			categoriaDb.setDescripcion(newCategoria.getDescripcion());
			
			
			categoriaService.update(categoriaDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{categoria_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer categoria_id)
	{
		Categoria categoriaDb=categoriaService.findById(categoria_id);
		
		if(categoriaDb!=null)
		{
			categoriaService.delete(categoria_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}


	
}
