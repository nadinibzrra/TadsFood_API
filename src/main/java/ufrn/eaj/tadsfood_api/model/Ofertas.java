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
@Table(name = "oferta")
public class Ofertas implements Serializable {

    @Id
    @Column(name = "id_oferta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String titulo;
    String descricao;
    String tipo;
    float valor;
    boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    Usuario usuario;

    /*
    public Ofertas(String titulo, String descricao, String tipo, float valor, boolean status, Usuario usuario){
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
        this.usuario = usuario;
    }
     */
}
