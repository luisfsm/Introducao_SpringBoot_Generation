package br.org.generation.blogpessoal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.blogpessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
