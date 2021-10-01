package br.org.generation.blogpessoal.Controller;

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

import br.org.generation.blogpessoal.Repository.TemasRepository;
import br.org.generation.blogpessoal.model.Temas;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class TemasController {

	@Autowired
	TemasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Temas>> getAllTemas(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/searchid/{id}")
	public ResponseEntity<Temas> getTemaById(@PathVariable long id){
		
		return repository.findById(id)
			   .map(response -> ResponseEntity.ok(response))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/searchdescricao/{descricao}")
	public ResponseEntity<List<Temas>>  getTemasAllDescricao(@PathVariable("descricao") String descricao){
		
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	
	@PostMapping("/insert")
	public ResponseEntity<Temas> insertTema(@RequestBody Temas tema){	
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Temas> putTemas(@RequestBody Temas tema){
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTema(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
	
	
}
