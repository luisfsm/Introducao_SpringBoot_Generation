package br.org.generation.blogpessoal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Temas;

@Repository
public interface TemasRepository extends JpaRepository<Temas, Long> {
	
	public List<Temas> findAllByDescricaoContainingIgnoreCase(String descricao);

}
