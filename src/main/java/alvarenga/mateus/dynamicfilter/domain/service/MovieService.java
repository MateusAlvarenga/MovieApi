package alvarenga.mateus.dynamicfilter.domain.service;

import alvarenga.mateus.dynamicfilter.domain.dto.input.MovieInput;
import alvarenga.mateus.dynamicfilter.domain.dto.output.MovieOutput;
import alvarenga.mateus.dynamicfilter.domain.filter.MovieFilter;
import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import alvarenga.mateus.dynamicfilter.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService
        extends CrudService<Movie, MovieRepository,Integer, MovieFilter, MovieInput, MovieOutput>{
}
