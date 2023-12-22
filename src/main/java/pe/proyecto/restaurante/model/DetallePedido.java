package pe.proyecto.restaurante.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detallePedido")
public class DetallePedido implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer detallePedido_id;
	@Column
	private Integer cantidad;
	@Column
	private Double precio_unitario;
	
	@Column(name = "producto_id", insertable = false, updatable = false)
	private Integer producto_id;
	
	@Column(name = "pedido_id", insertable = false, updatable = false)
	private Integer pedido_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(producto_id) references productos(producto_id)"))
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="pedido_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(pedido_id) references pedidos(pedido_id)"))
	private Pedido pedido;
	
	public DetallePedido() {
		
	}
	public DetallePedido(DetallePedido detallePedido) {
		this(detallePedido.getDetallePedido_id(),detallePedido.getCantidad(),detallePedido.getPrecio_unitario(),
				detallePedido.getProducto_id(),detallePedido.getPedido_id(),detallePedido.getProducto(),detallePedido.getPedido());
	}
	public DetallePedido(Integer detallePedido_id, Integer cantidad, Double precio_unitario, Integer producto_id,
			Integer pedido_id, Producto producto, Pedido pedido) {
		super();
		this.detallePedido_id = detallePedido_id;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.producto_id = producto_id;
		this.pedido_id = pedido_id;
		this.producto = producto;
		this.pedido = pedido;
	}
	public Integer getDetallePedido_id() {
		return detallePedido_id;
	}
	public void setDetallePedido_id(Integer detallePedido_id) {
		this.detallePedido_id = detallePedido_id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public Integer getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}
	public Integer getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(Integer pedido_id) {
		this.pedido_id = pedido_id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	
	
}
