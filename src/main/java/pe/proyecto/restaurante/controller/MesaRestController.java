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

import pe.proyecto.restaurante.model.Mesa;
import pe.proyecto.restaurante.service.MesaService;

@RestController 
@RequestMapping("/mesa")
public class MesaRestController {

	@Autowired
	private MesaService mesaService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Mesa> itemsMesa=mesaService.findAll();		
		return new ResponseEntity<>(itemsMesa,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{mesa_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer mesa_id)
	{
		Mesa mesaDb=mesaService.findById(mesa_id);
		
		if(mesaDb!=null) {
			return new ResponseEntity<>(mesaDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Mesa mesa)
	{
		mesaService.insert(mesa);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{mesa_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer mesa_id,
                                        @RequestBody Mesa newMesa)
	{		
		Mesa mesaDb=mesaService.findById(mesa_id);
		
		if(mesaDb!=null)
		{
			mesaDb.setDescripcion(newMesa.getDescripcion());
			mesaDb.setCantidad_asientos(newMesa.getCantidad_asientos());
			mesaDb.setEstado_mesa(newMesa.getEstado_mesa());
			
			
			mesaService.update(mesaDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{mesa_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer mesa_id)
	{
		Mesa mesaDb=mesaService.findById(mesa_id);
		
		if(mesaDb!=null)
		{
			mesaService.delete(mesa_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
