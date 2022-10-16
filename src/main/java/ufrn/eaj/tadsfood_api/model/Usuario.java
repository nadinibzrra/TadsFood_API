package ufrn.eaj.tadsfood_api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    String nome;
    String telefone;
    String username;
    String password;
    String papel;

    public Usuario(String nome, String telefone, String username, String password, Enum papel) {
        this.nome = nome;
        this.telefone = telefone;
        this.username = username;
        this.password = password;
        this.papel = String.valueOf(papel);
    }

    public Usuario(String nome, String telefone, String username, String password) {
        this.nome = nome;
        this.telefone = telefone;
        this.username = username;
        this.password = password;
    }
}
