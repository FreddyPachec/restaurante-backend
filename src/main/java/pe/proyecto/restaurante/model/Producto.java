package pe.proyecto.restaurante.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

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


@Entity
@Table(name="productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer producto_id;
	@Column
	private String nombre_producto;
	@Column
	private String descripcion;
	@Column
	private Double precio;
	@Column
	private Integer cantidad_stock;	
	@Column(name = "categoria_id", insertable = false, updatable = false)
	private Integer categoria_id;
	
	@OneToMany(mappedBy="producto")
	private Collection<Almacen> itemsAlmacen = new ArrayList<>();
	
	@OneToMany(mappedBy="producto")
	private Collection<DetallePedido> itemsDetallePedido = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(categoria_id) references categorias(categoria_id)"))
	private Categoria categoria;

	public Producto() {
		
	}
	public Producto(Producto producto)
	{
		this(producto.getProducto_id(), producto.getNombre_producto(),producto.getDescripcion(),
				producto.getPrecio(),producto.getCantidad_stock(),producto.getCategoria_id(),producto.getCategoria());
	}
	public Producto(Integer producto_id, String nombre_producto, String descripcion, Double precio,
			Integer cantidad_stock, Integer categoria_id, Categoria categoria) {
		super();
		this.producto_id = producto_id;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad_stock = cantidad_stock;
		this.categoria_id = categoria_id;
		this.categoria = categoria;
	}
	public Integer getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Integer productoId) {
		this.producto_id = productoId;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad_stock() {
		return cantidad_stock;
	}
	public void setCantidad_stock(Integer cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}
	public Integer getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
