package pe.proyecto.restaurante.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cliente_id;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column(unique = true, nullable = false, length = 9)
	private Integer telefono;	
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, nullable = false, length = 8)
	private Integer dni;
	
	@OneToMany(mappedBy="cliente")
	private Collection<Pedido> itemsPedido = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente")
	private Collection<Venta> itemsVenta = new ArrayList<>();
	
	public Cliente() {
		
	}
	public Cliente(Cliente cliente) {
		this(cliente.getCliente_id(),cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono(),cliente.getEmail(),cliente.getDni());		
	}
	public Cliente(Integer cliente_id, String nombre, String direccion, Integer telefono, String email, Integer dni) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
}
