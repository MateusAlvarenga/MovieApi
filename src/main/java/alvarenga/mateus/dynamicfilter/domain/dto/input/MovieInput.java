package alvarenga.mateus.dynamicfilter.domain.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieInput {

    private String nome;
    private String descricao;
    private String autor;
}
