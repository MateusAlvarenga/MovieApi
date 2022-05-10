package alvarenga.mateus.dynamicfilter.domain.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieOutput {

    private Integer id;
    private String nome;
    private String descricao;
    private String autor;
}
