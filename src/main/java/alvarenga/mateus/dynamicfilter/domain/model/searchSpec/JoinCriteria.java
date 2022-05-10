package alvarenga.mateus.dynamicfilter.domain.model.searchSpec;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

/**
 * The type Join criteria.
 */
@Getter
public class JoinCriteria {

    private Specification<?> specification;
    private String tableName;

    /**
     * Instantiates a new Join criteria.
     *
     * @param specification the specification
     * @param tableName     the table name
     */
    public JoinCriteria(Specification<?> specification, String tableName) {
        this.specification = specification;
        this.tableName = tableName;
    }
}
