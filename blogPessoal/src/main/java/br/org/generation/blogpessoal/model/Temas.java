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
@Table(name="TB_TEMAS")
public class Temas {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@Size(min=5,max=255)
	private String descricao;
	
	@OneToMany(mappedBy = "temas")
	private List<Postagem> postagem = new ArrayList<>();
	
	
	

}
