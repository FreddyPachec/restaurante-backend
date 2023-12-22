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

import pe.proyecto.restaurante.model.Venta;
import pe.proyecto.restaurante.service.VentaService;

@RestController 
@RequestMapping("/venta")
public class VentaRestController {

	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Venta> itemsVenta=ventaService.findAll();		
		return new ResponseEntity<>(itemsVenta,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{venta_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer venta_id)
	{
		Venta ventaDb=ventaService.findById(venta_id);
		
		if(ventaDb!=null) {
			return new ResponseEntity<>(ventaDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Venta venta)
	{
		ventaService.insert(venta);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{venta_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer venta_id,
                                        @RequestBody Venta newVenta)
	{		
		Venta ventaDb=ventaService.findById(venta_id);
		
		if(ventaDb!=null)
		{
			ventaDb.setTotal_venta(newVenta.getTotal_venta());
			ventaDb.setFecha_venta(newVenta.getFecha_venta());
			ventaDb.setPedido_id(newVenta.getPedido_id());
			ventaDb.setCliente_id(newVenta.getCliente_id());
			ventaDb.setPedido(newVenta.getPedido());
			ventaDb.setCliente(newVenta.getCliente());
			
			
			ventaService.update(ventaDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{venta_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer venta_id)
	{
		Venta ventaDb=ventaService.findById(venta_id);
		
		if(ventaDb!=null)
		{
			ventaService.delete(venta_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
