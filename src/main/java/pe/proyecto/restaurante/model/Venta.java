package pe.proyecto.restaurante.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="ventas")
public class Venta implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer venta_id;	
	@Column
	private Double total_venta;	
	@Temporal(TemporalType.DATE)
	private Date fecha_venta;
	
	@Column(name = "pedido_id", insertable = false, updatable = false)
	private Integer pedido_id;
	
	@Column(name = "cliente_id", insertable = false, updatable = false)
	private Integer cliente_id;
	
	@ManyToOne
	@JoinColumn(name="pedido_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(pedido_id) references pedidos(pedido_id)"))
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="cliente_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(cliente_id) references clientes(cliente_id)"))
	private Cliente cliente;
	
	public Venta() {
		
	}
	public Venta(Venta venta) {
		this(venta.getVenta_id(),venta.getTotal_venta(),venta.getFecha_venta(),
				venta.getPedido_id(),venta.getCliente_id(),venta.getPedido(),venta.getCliente());
	}
	public Venta(Integer venta_id, Double total_venta, Date fecha_venta, Integer pedido_id, Integer cliente_id,
			Pedido pedido, Cliente cliente) {
		super();
		this.venta_id = venta_id;
		this.total_venta = total_venta;
		this.fecha_venta = fecha_venta;
		this.pedido_id = pedido_id;
		this.cliente_id = cliente_id;
		this.pedido = pedido;
		this.cliente = cliente;
	}
	public void prePersist() {
		fecha_venta = new Date();
	}
	public Integer getVenta_id() {
		return venta_id;
	}
	public void setVenta_id(Integer venta_id) {
		this.venta_id = venta_id;
	}
	public Double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	public Date getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public Integer getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(Integer pedido_id) {
		this.pedido_id = pedido_id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
}
