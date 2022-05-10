package alvarenga.mateus.dynamicfilter.domain.dto.input;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieInput {
    private String nome;
    private String descricao;
    private String autor;
}
