package alvarenga.mateus.dynamicfilter.domain.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    @Column(name = "autor", nullable = false)
    private String autor;


}