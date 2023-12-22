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
@Table(name="almacenes")
public class Almacen implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer almacen_id;
	@Column
	private Integer cantidad_stock;
	@Column
	private String fecha_ultima_actualización;
	@Column(name = "producto_id", insertable = false, updatable = false)
	private Integer producto_id;
	
	@ManyToOne
	@JoinColumn(name="producto_id",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(producto_id) references productos(producto_id)"))
	private Producto producto;
	
	public Almacen() {
		
	}
	
	public Almacen(Almacen almacen) {
		this(almacen.getAlmacen_id(),almacen.getCantidad_stock(),almacen.getFecha_ultima_actualización(),
				almacen.getProducto_id(),almacen.getProducto());
	}

	public Almacen(Integer almacen_id, Integer cantidad_stock, String fecha_ultima_actualización, Integer producto_id,
			Producto producto) {
		super();
		this.almacen_id = almacen_id;
		this.cantidad_stock = cantidad_stock;
		this.fecha_ultima_actualización = fecha_ultima_actualización;
		this.producto_id = producto_id;
		this.producto = producto;
	}

	public Integer getAlmacen_id() {
		return almacen_id;
	}

	public void setAlmacen_id(Integer almacen_id) {
		this.almacen_id = almacen_id;
	}

	public Integer getCantidad_stock() {
		return cantidad_stock;
	}

	public void setCantidad_stock(Integer cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}

	public String getFecha_ultima_actualización() {
		return fecha_ultima_actualización;
	}

	public void setFecha_ultima_actualización(String fecha_ultima_actualización) {
		this.fecha_ultima_actualización = fecha_ultima_actualización;
	}

	public Integer getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
