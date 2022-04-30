package alvarenga.mateus.dynamicfilter.domain.model.searchSpec;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
}