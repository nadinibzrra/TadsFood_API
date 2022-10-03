package ufrn.eaj.tadsfood_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufrn.eaj.tadsfood_api.model.Ofertas;

@Repository
public interface OfertasRepository extends JpaRepository<Ofertas, Long> {
}
