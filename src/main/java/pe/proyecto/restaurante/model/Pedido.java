package pe.proyecto.restaurante.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Pedidos")
public class Pedido implements Serializable   {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pedido_id;
	@Temporal(TemporalType.DATE)
	private Date fecha_pedido;
	@Column
	private Integer estado_pedido;
	@Column(name = "mesa_id", insertable = false, updatable = false)
	private Integer mesa_id;
	@Column(name = "empleado_id", insertable = false, updatable = false)
	private Integer empleado_id;
	@Column(name = "cliente_id", insertable = false, updatable = false)
	private Integer cliente_id;

	
	@OneToMany(mappedBy="pedido")
	private Collection<DetallePedido> itemsDetallePedido = new ArrayList<>();
	
	@OneToMany(mappedBy="pedido")
	private Collection<Venta> itemsVenta = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="empleado_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(empleado_id) references empleados(empleado_id)"))
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="mesa_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(mesa_id) references mesas(mesa_id)"))
	private Mesa mesa;
	
	@ManyToOne
	@JoinColumn(name="cliente_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(cliente_id) references clientes(cliente_id)"))
	private Cliente cliente;
	
	public Pedido() {
		
	}
	public Pedido(Pedido pedido) {
		this(pedido.getPedido_id(),pedido.getFecha_pedido(),pedido.getEstado_pedido(),pedido.getMesa_id(),
				pedido.getEmpleado_id(),pedido.getCliente_id(),pedido.getEmpleado(),pedido.getMesa(),pedido.getCliente());
	}
	public Pedido(Integer pedido_id, Date fecha_pedido, Integer estado_pedido, Integer mesa_id, Integer empleado_id,
			Integer cliente_id, Empleado empleado, Mesa mesa, Cliente cliente) {
		super();
		this.pedido_id = pedido_id;
		this.fecha_pedido = fecha_pedido;
		this.estado_pedido = estado_pedido;
		this.mesa_id = mesa_id;
		this.empleado_id = empleado_id;
		this.cliente_id = cliente_id;
		this.empleado = empleado;
		this.mesa = mesa;
		this.cliente = cliente;
	}
	public void prePersist() {
		fecha_pedido = new Date();
	}
	public Integer getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(Integer pedido_id) {
		this.pedido_id = pedido_id;
	}
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public Integer getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(Integer estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public Integer getMesa_id() {
		return mesa_id;
	}
	public void setMesa_id(Integer mesa_id) {
		this.mesa_id = mesa_id;
	}
	public Integer getEmpleado_id() {
		return empleado_id;
	}
	public void setEmpleado_id(Integer empleado_id) {
		this.empleado_id = empleado_id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
