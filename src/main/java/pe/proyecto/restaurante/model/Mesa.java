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
@Table(name="mesas")
public class Mesa implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer mesa_id;
	@Column
	private String descripcion;
	@Column
	private Integer cantidad_asientos;	
	@Column
	private Integer estado_mesa;	
	@OneToMany(mappedBy="mesa")
	private Collection<Pedido> itemsPedido = new ArrayList<>();
	
	public Mesa() {
		
	}
	public Mesa(Mesa mesa) {
		this(mesa.getMesa_id(),mesa.getDescripcion(),mesa.getCantidad_asientos(),mesa.getEstado_mesa());
	}
	public Mesa(Integer mesa_id, String descripcion, Integer cantidad_asientos, Integer estado_mesa) {
		super();
		this.mesa_id = mesa_id;
		this.descripcion = descripcion;
		this.cantidad_asientos = cantidad_asientos;
		this.estado_mesa = estado_mesa;
	}
	public Integer getMesa_id() {
		return mesa_id;
	}
	public void setMesa_id(Integer mesa_id) {
		this.mesa_id = mesa_id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantidad_asientos() {
		return cantidad_asientos;
	}
	public void setCantidad_asientos(Integer cantidad_asientos) {
		this.cantidad_asientos = cantidad_asientos;
	}
	public Integer getEstado_mesa() {
		return estado_mesa;
	}
	public void setEstado_mesa(Integer estado_mesa) {
		this.estado_mesa = estado_mesa;
	}
	
}
