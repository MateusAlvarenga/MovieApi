package alvarenga.mateus.dynamicfilter.domain.model.searchSpec;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Search criteria.
 */
@Getter @Setter
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;

    /**
     * Instantiates a new Search criteria.
     *
     * @param key       the key of the search criteria
     * @param value     the value of the search criteria
     * @param operation the operation of the search criteria
     */
    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
}