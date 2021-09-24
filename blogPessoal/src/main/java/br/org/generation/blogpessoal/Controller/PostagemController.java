package br.org.generation.blogpessoal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.Repository.PostagemRepository;
import br.org.generation.blogpessoal.model.Postagem;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("idpost/{id}")
	public ResponseEntity<Optional<Postagem>> GetById(@PathVariable("id") long id ){
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@GetMapping("/filtertitulo/{post}")
	public ResponseEntity<List<Postagem>> GetAllByTitulo(@PathVariable("post") String nome){
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(nome));
	}
	
	@PostMapping("/insertposts")
	public void InsertPosts(@RequestBody Postagem postagem ) {	
		ResponseEntity.ok(repository.save(postagem));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePost(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
	
}
