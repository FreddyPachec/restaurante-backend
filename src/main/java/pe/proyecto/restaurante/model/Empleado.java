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
@Table(name="empleados")
public class Empleado implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empleado_id;
	@Column
	private String nombre;
	@Column
	private String posicion;
	@Column
	private String fecha_contrato;
	@Column
	private Integer estado_empleado;
	@OneToMany(mappedBy="empleado")
	private Collection<Pedido> itemsPedido = new ArrayList<>();
	
	public Empleado() {
		
	}
	public Empleado(Empleado empleado) {
		this(empleado.getEmpleado_id(),empleado.getNombre(),empleado.getPosicion(),
				empleado.getFecha_contrato(),empleado.getEstado_empleado());
	}
	public Empleado(Integer empleado_id, String nombre, String posicion, String fecha_contrato,
			Integer estado_empleado) {
		super();
		this.empleado_id = empleado_id;
		this.nombre = nombre;
		this.posicion = posicion;
		this.fecha_contrato = fecha_contrato;
		this.estado_empleado = estado_empleado;
	}
	public Integer getEmpleado_id() {
		return empleado_id;
	}
	public void setEmpleado_id(Integer empleado_id) {
		this.empleado_id = empleado_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getFecha_contrato() {
		return fecha_contrato;
	}
	public void setFecha_contrato(String fecha_contrato) {
		this.fecha_contrato = fecha_contrato;
	}
	public Integer getEstado_empleado() {
		return estado_empleado;
	}
	public void setEstado_empleado(Integer estado_empleado) {
		this.estado_empleado = estado_empleado;
	}
	
}
