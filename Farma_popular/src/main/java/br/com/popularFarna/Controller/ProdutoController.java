package br.com.popularFarna.Controller;

import java.util.List;

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

import br.com.popularFarna.Model.ProdutoModel;
import br.com.popularFarna.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAllProduto(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getAllProdutoBy(@PathVariable("id") long id){
		return repository.findById(id)
			   .map(resposta -> ResponseEntity.ok(resposta))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/filter/{produto}")
	public ResponseEntity<List<ProdutoModel>> getAllProdutoFilter(@PathVariable("produto") String produto){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(produto));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduto(@PathVariable("id") long ID) {
		repository.deleteById(ID);
	}
}
