package br.com.atividadesemanal.Service;

import java.util.List;

import br.com.atividadesemanal.Model.Model;

@org.springframework.stereotype.Service
public class Service extends Model {
	
	
	Model model = new Model();

	public void listaPadrao() {
		if(model.atividade.isEmpty()) {
			model.atividade.add("Java");
			model.atividade.add("Spring");
		}
	}
	
	public List<String> listarAtividade(){
		this.listaPadrao();
		return model.atividade;
	}

	
	public void InserirNaLista(String nome) {
		model.atividade.add(nome);
	}
	
	public void DeletarLista(String nome) {
		this.listaPadrao();
		if(model.atividade.contains(nome)) {
			model.atividade.remove(nome);
		}
	}
	
	public void AtualizarLista(String antigo,String novo) {
		
		if(model.atividade.contains(antigo)) {
			model.atividade.remove(antigo);
			model.atividade.add(novo);
		}
		
	}
}
