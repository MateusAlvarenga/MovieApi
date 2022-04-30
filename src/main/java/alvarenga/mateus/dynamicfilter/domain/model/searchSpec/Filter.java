package alvarenga.mateus.dynamicfilter.domain.model.searchSpec;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;


public interface Filter {
    public Specification<?> getSpecification();
}
