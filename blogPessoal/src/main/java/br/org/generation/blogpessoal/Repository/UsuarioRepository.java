package br.org.generation.blogpessoal.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.blogpessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String usuario);
	

	//Método criado para a Sessão de testes 01
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	//Método criado para a Sessão de testes 02
	public Usuario findByNome(String nome);
}
