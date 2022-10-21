package ufrn.eaj.tadsfood_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.eaj.tadsfood_api.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByUsername(String username);
    Usuario findByUsername(String userName);
    //Optional<Usuario> findById();
    //Optional<Usuario> findUsuarioBy(Long id);
}
