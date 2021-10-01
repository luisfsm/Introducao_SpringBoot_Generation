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
import br.com.popularFarna.Model.CategoriaModel;
import br.com.popularFarna.Repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAllCategoria(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping("/filter/{medicamento}")
	public ResponseEntity<List<CategoriaModel>> getAllFilterMedicamento(@PathVariable("medicamento") String medicamento){
		return ResponseEntity.ok(repository.findAllByMedicamentoContainingIgnoreCase(medicamento));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getByIdCategoria(@PathVariable("id") long id){
		return repository.findById(id)
			   .map(resposta -> ResponseEntity.ok(resposta))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
	
}
