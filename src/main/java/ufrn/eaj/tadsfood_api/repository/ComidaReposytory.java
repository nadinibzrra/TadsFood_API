package ufrn.eaj.tadsfood_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.eaj.tadsfood_api.model.Comida;
import ufrn.eaj.tadsfood_api.model.Usuario;

import java.util.Optional;

public interface ComidaReposytory extends JpaRepository<Comida, Long> {
    Comida findComidaById(Long id);
    void deleteComidaByUsuario(Usuario usuario);
    Optional<Comida> findById(Long id);
}
