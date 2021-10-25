package br.org.generation.blogpessoal.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.Repository.PostagemRepository;
import br.org.generation.blogpessoal.model.Postagem;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders =  "*")
public class PostagemController {
	
	@Autowired
	PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable("id") long id ){
		return repository.findById(id)
			   .map(resposta -> ResponseEntity.ok(resposta))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{post}")
	public ResponseEntity<List<Postagem>> GetAllByTitulo(@PathVariable("post") String nome){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(nome));
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Postagem> InsertPosts(@RequestBody Postagem postagem ) {	
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Postagem> updatePost(@RequestBody Postagem postagem) {
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePost(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
	
}
