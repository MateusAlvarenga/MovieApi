package alvarenga.mateus.dynamicfilter.domain.filter;

import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.Filter;
import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.GenericSpesification;
import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.SearchCriteria;
import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.SearchOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class MovieFilter implements Filter {
    private Integer id;
    private String nome;
    private String descricao;
    private String autor;
    private String nomeExato;

    @Override
    public Specification<?> getSpecification() {
        GenericSpesification<Movie> genericSpesification = new GenericSpesification<Movie>();

        if(Objects.nonNull(getId())) {
            genericSpesification.add(new SearchCriteria("id",getId(), SearchOperation.EQUAL));
        }
        if(Objects.nonNull(getNome())) {
            genericSpesification.add(new SearchCriteria("nome",getNome(), SearchOperation.MATCH));
        }
        if(Objects.nonNull(getNomeExato())) {
            genericSpesification.add(new SearchCriteria("nome",getNomeExato(), SearchOperation.EQUAL));
        }
        if(Objects.nonNull(getDescricao())) {
            genericSpesification.add(new SearchCriteria("descricao",getDescricao(), SearchOperation.MATCH));
        }
        if(Objects.nonNull(getAutor())) {
            genericSpesification.add(new SearchCriteria("autor",getAutor(), SearchOperation.MATCH));
        }

        return genericSpesification;
    }
}
