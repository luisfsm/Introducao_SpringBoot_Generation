package br.org.generation.blogpessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long    id;
	
	
	@NotNull
	@Size(min = 3, max=255)
	private String  nome;
	
	@NotNull
	@Size(min = 3, max=255)
	private String  senha;

	@OneToMany(mappedBy="usuarios")
	private List<Postagem> postagem = new ArrayList<>(); 
}
