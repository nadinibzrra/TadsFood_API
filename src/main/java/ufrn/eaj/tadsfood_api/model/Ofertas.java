package ufrn.eaj.tadsfood_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ofertas")
public class Ofertas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private long id;
    private String nome;
    private String telefone;
    private String descricao;
    private String tipo;
    private float valor;
    private boolean status;
}
