package alvarenga.mateus.dynamicfilter.domain.model.searchSpec;

import org.springframework.data.jpa.domain.Specification;

/**
 * The interface Filter.
 */
public interface Filter {
    /**
     * Gets specification.
     *
     * @return the specification
     */
    public Specification<?> getSpecification();
}
