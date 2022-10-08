package ufrn.eaj.tadsfood_api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    String nome;
    String celular;
    String username;
    String password;
    String papel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ofertas_id")
    List<Ofertas> ofertas;

    public Usuario(String nome, String celular, String username, String password, Enum papel, List<Ofertas> ofertas) {
        this.nome = nome;
        this.celular = celular;
        this.username = username;
        this.password = password;
        this.papel = String.valueOf(papel);
        this.ofertas = ofertas;
    }
}
