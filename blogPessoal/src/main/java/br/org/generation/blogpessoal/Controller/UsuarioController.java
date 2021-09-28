package br.org.generation.blogpessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.Repository.UsuarioRepository;
import br.org.generation.blogpessoal.model.Usuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins ="*", allowedHeaders = "*" )
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuario(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	
}
