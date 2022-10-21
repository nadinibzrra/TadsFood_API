package ufrn.eaj.tadsfood_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.eaj.tadsfood_api.model.Comida;

public interface ComidaReposytory extends JpaRepository<Comida, Long> {
}
