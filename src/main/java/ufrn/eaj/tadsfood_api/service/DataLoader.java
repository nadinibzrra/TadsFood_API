package ufrn.eaj.tadsfood_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ufrn.eaj.tadsfood_api.model.Ofertas;
import ufrn.eaj.tadsfood_api.model.Usuario;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    OfertasService ofertasService;

    @Override
    public void run(String... args) throws Exception {

        //Enum<Papel> papelEnum = new Papel("usuario");

        //Usuario clara = new Usuario("Clara", "84 99167 9677", "clara", "password");
        //usuarioService.save(clara);

        //Ofertas ofertaClara = new Ofertas(1,"pastel", "pastel de frango", "salgado", 3, true, clara);
        //ofertasService.save(ofertaClara);
    }
}
