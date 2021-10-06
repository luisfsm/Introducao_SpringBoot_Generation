package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="TB_POSTAGEM")
public class Postagem {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;

	@NotNull(message = "O Atributo titulo e obrigatrio")
	@Size(min = 5, max = 100)
	private String titulo;

	@NotNull(message = "O Atributo texto e obrigatrio")
	@Size(min = 5, max = 100)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date 	data = new java.sql.Date(System.currentTimeMillis());
	


	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Temas temas;

	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuarios;
	
		public Usuario getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Temas getTemas() {
		return temas;
	}
	public void setTemas(Temas temas) {
		this.temas = temas;
	}
	
}
