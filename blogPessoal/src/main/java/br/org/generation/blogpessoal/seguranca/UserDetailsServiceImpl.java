package br.org.generation.blogpessoal.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.blogpessoal.Repository.UsuarioRepository;
import br.org.generation.blogpessoal.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	UsuarioRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException  {
		Optional<Usuario> user = repository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found"));
		
		return user.map(UserDetailsImpl::new).get();
	}

	
}
