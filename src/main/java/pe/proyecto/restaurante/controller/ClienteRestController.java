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

import pe.proyecto.restaurante.model.Cliente;
import pe.proyecto.restaurante.service.ClienteService;

@RestController 
@RequestMapping("/cliente")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Cliente> itemsCliente=clienteService.findAll();		
		return new ResponseEntity<>(itemsCliente,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{cliente_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer cliente_id)
	{
		Cliente clienteDb=clienteService.findById(cliente_id);
		
		if(clienteDb!=null) {
			return new ResponseEntity<>(clienteDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Cliente cliente)
	{
		clienteService.insert(cliente);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{cliente_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer cliente_id,
                                        @RequestBody Cliente newCliente)
	{		
		Cliente clienteDb=clienteService.findById(cliente_id);
		
		if(clienteDb!=null)
		{
			clienteDb.setNombre(newCliente.getNombre());
			clienteDb.setDireccion(newCliente.getDireccion());
			clienteDb.setTelefono(newCliente.getTelefono());
			clienteDb.setEmail(newCliente.getEmail());
			clienteDb.setDni(newCliente.getDni());
			
			
			clienteService.update(clienteDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{cliente_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer cliente_id)
	{
		Cliente clienteDb=clienteService.findById(cliente_id);
		
		if(clienteDb!=null)
		{
			clienteService.delete(cliente_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
