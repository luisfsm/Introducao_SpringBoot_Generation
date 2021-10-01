package br.com.popularFarna.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.popularFarna.Model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	public List<ProdutoModel> findAllByDescricaoContainingIgnoreCase(String descricao);

}
