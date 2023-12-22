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

import pe.proyecto.restaurante.model.DetallePedido;
import pe.proyecto.restaurante.service.DetallePedidoService;

@RestController 
@RequestMapping("/DetallePedido")
public class DetallePedidoRestController {

	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<DetallePedido> itemsDetallePedido=detallePedidoService.findAll();		
		return new ResponseEntity<>(itemsDetallePedido,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{detallePedido_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer detallePedido_id)
	{
		DetallePedido detallePedidoDb=detallePedidoService.findById(detallePedido_id);
		
		if(detallePedidoDb!=null) {
			return new ResponseEntity<>(detallePedidoDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody DetallePedido detallePedido)
	{
		detallePedidoService.insert(detallePedido);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{detallePedido_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer detallePedido_id,
                                        @RequestBody DetallePedido newDetallePedido)
	{		
		DetallePedido detallePedidoDb=detallePedidoService.findById(detallePedido_id);
		
		if(detallePedidoDb!=null)
		{
			detallePedidoDb.setCantidad(newDetallePedido.getCantidad());
			detallePedidoDb.setPrecio_unitario(newDetallePedido.getPrecio_unitario());
			detallePedidoDb.setProducto_id(newDetallePedido.getProducto_id());
			detallePedidoDb.setPedido_id(newDetallePedido.getPedido_id());
			detallePedidoDb.setProducto(newDetallePedido.getProducto());
			detallePedidoDb.setPedido(newDetallePedido.getPedido());
			
			
			detallePedidoService.update(detallePedidoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{detallePedido_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer detallePedido_id)
	{
		DetallePedido detallePedidoDb=detallePedidoService.findById(detallePedido_id);
		
		if(detallePedidoDb!=null)
		{
			detallePedidoService.delete(detallePedido_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
