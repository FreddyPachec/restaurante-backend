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

import pe.proyecto.restaurante.model.Almacen;
import pe.proyecto.restaurante.service.AlmacenService;

@RestController 
@RequestMapping("/almacen")
public class AlmacenRestController {

	@Autowired
	private AlmacenService almacenService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Almacen> itemsAlmacen=almacenService.findAll();		
		return new ResponseEntity<>(itemsAlmacen,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{almacen_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer almacen_id)
	{
		Almacen almacenDb=almacenService.findById(almacen_id);
		
		if(almacenDb!=null) {
			return new ResponseEntity<>(almacenDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Almacen almacen)
	{
		almacenService.insert(almacen);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{almacen_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer almacen_id,
                                        @RequestBody Almacen newAlmacen)
	{		
		Almacen almacenDb=almacenService.findById(almacen_id);
		
		if(almacenDb!=null)
		{
			almacenDb.setCantidad_stock(newAlmacen.getCantidad_stock());
			almacenDb.setFecha_ultima_actualización(newAlmacen.getFecha_ultima_actualización());
			almacenDb.setProducto_id(newAlmacen.getProducto_id());
			almacenDb.setProducto(newAlmacen.getProducto());
			
			almacenService.update(almacenDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{almacen_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer almacen_id)
	{
		Almacen almacenDb=almacenService.findById(almacen_id);
		
		if(almacenDb!=null)
		{
			almacenService.delete(almacen_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
