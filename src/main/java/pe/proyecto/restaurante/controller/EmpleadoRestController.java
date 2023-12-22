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

import pe.proyecto.restaurante.model.Empleado;
import pe.proyecto.restaurante.service.EmpleadoService;

@RestController 
@RequestMapping("/empleado")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() 
	{
		Collection<Empleado> itemsEmpleado=empleadoService.findAll();		
		return new ResponseEntity<>(itemsEmpleado,HttpStatus.OK); //Http status code
	}
	@GetMapping("/buscar/{empleado_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer empleado_id)
	{
		Empleado empleadoDb=empleadoService.findById(empleado_id);
		
		if(empleadoDb!=null) {
			return new ResponseEntity<>(empleadoDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Empleado empleado)
	{
		empleadoService.insert(empleado);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{empleado_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer empleado_id,
                                        @RequestBody Empleado newEmpleado)
	{		
		Empleado empleadoDb=empleadoService.findById(empleado_id);
		
		if(empleadoDb!=null)
		{
			empleadoDb.setNombre(newEmpleado.getNombre());
			empleadoDb.setPosicion(newEmpleado.getPosicion());
			empleadoDb.setFecha_contrato(newEmpleado.getFecha_contrato());
			empleadoDb.setEstado_empleado(newEmpleado.getEstado_empleado());
			
			
			empleadoService.update(empleadoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{empleado_id}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer empleado_id)
	{
		Empleado empleadoDb=empleadoService.findById(empleado_id);
		
		if(empleadoDb!=null)
		{
			empleadoService.delete(empleado_id);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

}
