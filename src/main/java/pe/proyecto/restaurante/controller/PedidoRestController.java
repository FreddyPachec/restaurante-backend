package pe.proyecto.restaurante.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.proyecto.restaurante.model.Pedido;
import pe.proyecto.restaurante.service.PedidoService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController 
@RequestMapping("/pedido")
public class PedidoRestController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Pedido> itemsPedido=pedidoService.findAll();		
		return new ResponseEntity<>(itemsPedido,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{pedido_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer pedido_id)
	{
		Pedido pedidoDb=pedidoService.findById(pedido_id);
		
		if(pedidoDb!=null) {
			return new ResponseEntity<>(pedidoDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Pedido pedido)
	{
		pedidoService.insert(pedido);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{pedido_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer pedido_id,
                                        @RequestBody Pedido newPedido)
	{		
		Pedido pedidoDb=pedidoService.findById(pedido_id);
		
		if(pedidoDb!=null)
		{
			pedidoDb.setFecha_pedido(newPedido.getFecha_pedido());
			pedidoDb.setEstado_pedido(newPedido.getEstado_pedido());
			pedidoDb.setMesa_id(newPedido.getMesa_id());
			pedidoDb.setEmpleado_id(newPedido.getEmpleado_id());
			pedidoDb.setEmpleado(newPedido.getEmpleado());
			pedidoDb.setMesa(newPedido.getMesa());
			pedidoDb.setCliente(newPedido.getCliente());
			
			
			
			pedidoService.update(pedidoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{pedido_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer pedido_id)
	{
		Pedido pedidoDb=pedidoService.findById(pedido_id);
		
		if(pedidoDb!=null)
		{
			pedidoService.delete(pedido_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
