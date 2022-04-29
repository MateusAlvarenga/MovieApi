package alvarenga.mateus.dynamicfilter.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class MovieFilter extends Filter {
    private Integer id;
    private String nome;
    private String descricao;
    private String autor;
}
