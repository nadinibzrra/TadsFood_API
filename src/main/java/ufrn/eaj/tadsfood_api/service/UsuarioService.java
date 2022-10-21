package ufrn.eaj.tadsfood_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.repository.UsuarioRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    public void setRepository(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = repository.findUsuarioByUsername(username);

        if(optional.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    optional.get().getUsername(),
                    optional.get().getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(optional.get().getPapel()))
            );
        }
        throw new UsernameNotFoundException("User not found");
    }

    public Usuario retornaUsuarioLogin(String username) throws UsernameNotFoundException {
        Usuario optional = repository.findByUsername(username);

        if(optional != null) {
            return optional;
        }
        throw new UsernameNotFoundException("User not found");
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario save(Usuario usuario){
        return repository.save(usuario);
    }

    /*
    public Optional<Usuario> findUsuarioById(Long id){
        return repository.findUsuarioBy(id);
    }

    public Optional<Usuario> findById(Long id){
        return repository.findById(id);
    }
     */
    public Usuario findByUsername(String username){
        return repository.findByUsername(username);
    }

}
