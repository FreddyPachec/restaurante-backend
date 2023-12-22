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

import pe.proyecto.restaurante.model.Producto;
import pe.proyecto.restaurante.service.ProductoService;

@RestController 
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Producto> itemsProducto=productoService.findAll();		
		return new ResponseEntity<>(itemsProducto,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{producto_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer producto_id)
	{
		Producto productoDb=productoService.findById(producto_id);
		
		if(productoDb!=null) {
			return new ResponseEntity<>(productoDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Producto producto)
	{
		productoService.insert(producto);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{producto_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer producto_id,
                                        @RequestBody Producto newProducto)
	{		
		Producto productoDb=productoService.findById(producto_id);
		
		if(productoDb!=null)
		{
			productoDb.setNombre_producto(newProducto.getNombre_producto());
			productoDb.setDescripcion(newProducto.getDescripcion());
			productoDb.setPrecio(newProducto.getPrecio());
			productoDb.setCantidad_stock(newProducto.getCantidad_stock());
			productoDb.setCategoria_id(newProducto.getCategoria_id());
			productoDb.setCategoria(newProducto.getCategoria());			
			
			productoService.update(productoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{producto_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer producto_id)
	{
		Producto productoDb=productoService.findById(producto_id);
		
		if(productoDb!=null)
		{
			productoService.delete(producto_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}


}
