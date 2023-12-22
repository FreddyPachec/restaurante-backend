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
@Table(name="categorias")
public class Categoria implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoria_id;
	@Column
	private String nombre_categoria;
	@Column
	private String descripcion;
	
	@OneToMany(mappedBy="categoria")
	private Collection<Producto> itemsProducto = new ArrayList<>();
	
	
	public Categoria() {
		
	}
	
	public Categoria(Categoria categoria) {
		this(categoria.getCategoria_id(),categoria.getNombre_categoria(),categoria.getDescripcion());
	}

	public Categoria(Integer categoria_id, String nombre_categoria, String descripcion) {
		super();
		this.categoria_id = categoria_id;
		this.nombre_categoria = nombre_categoria;
		this.descripcion = descripcion;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}

