package alvarenga.mateus.dynamicfilter.domain.repository;

import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie> {
}