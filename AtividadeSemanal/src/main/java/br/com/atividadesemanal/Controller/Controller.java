package br.com.atividadesemanal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atividadesemanal.Service.Service;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	Service service;
	
	@GetMapping("/")
	public List<String> listarAtividade() {
		return service.listarAtividade();
	}
	
	

	@PostMapping("/adicionar/{nome}")
	public void AdicionarLista(@PathVariable("nome") String nome) {
		service.InserirNaLista(nome);	
	}	
	
	@DeleteMapping("/remover/{nome}")
	public void DeletarLista(@PathVariable("nome") String nome) {
		service.DeletarLista(nome);	
	}
	@PutMapping("/atualizar/{novo}/{antigo}")
	public void AtualizarLista(@PathVariable("novo") String antigo, @PathVariable("antigo") String novo) {
		service.AtualizarLista(antigo,novo);	
	}	
	
}
