package ufrn.eaj.tadsfood_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comida")
public class Comida {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(length = 150)
    private String titulo;

    @Column(length = 250)
    private String descricao;

    @Column(length = 100)
    private String tipo;

    @Column
    private float valor;

    @Column
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JsonManagedReference
    private Usuario usuario;

    public Comida(String titulo, String descricao, String tipo,float valor,boolean status, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
        this.usuario = usuario;
    }
}
