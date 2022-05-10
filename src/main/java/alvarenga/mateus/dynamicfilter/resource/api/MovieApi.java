package alvarenga.mateus.dynamicfilter.resource.api;

import alvarenga.mateus.dynamicfilter.domain.filter.MovieFilter;
import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import alvarenga.mateus.dynamicfilter.domain.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieApi  extends CrudController<Movie, MovieService,Integer, MovieFilter,Movie,Movie> {
}
