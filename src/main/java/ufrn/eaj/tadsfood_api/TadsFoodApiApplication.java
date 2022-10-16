package ufrn.eaj.tadsfood_api;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ufrn.eaj.tadsfood_api.enums.Papel;
import ufrn.eaj.tadsfood_api.model.Usuario;
import ufrn.eaj.tadsfood_api.repository.UsuarioRepository;

@SpringBootApplication
public class TadsFoodApiApplication {

    @Autowired
    private UsuarioRepository repository;

    @PostConstruct
    public void initUsers() {

        List<Usuario> users = Stream.of(
                new Usuario("Manoel", "manoel@gmail.com", "super", encoder().encode("admin"), Papel.SUPER),
                new Usuario("João", "joao@gmail.com", "user", encoder().encode("user1"), Papel.USUARIO),
                new Usuario("Maria", "maria@gmail.com", "admin", encoder().encode("user2"), Papel.ADMINISTRADOR))
                .collect(Collectors.toList());

        repository.saveAll(users);

    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(TadsFoodApiApplication.class, args);
    }

}
