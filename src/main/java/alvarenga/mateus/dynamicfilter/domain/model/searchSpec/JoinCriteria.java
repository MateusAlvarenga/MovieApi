package alvarenga.mateus.dynamicfilter.domain.model.searchSpec;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

@Getter
public class JoinCriteria {

    private Specification<?> specification;
    private String tableName;

    public JoinCriteria(Specification<?> specification, String tableName) {
        this.specification = specification;
        this.tableName = tableName;
    }
}
