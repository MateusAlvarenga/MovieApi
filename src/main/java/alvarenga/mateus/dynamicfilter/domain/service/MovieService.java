package alvarenga.mateus.dynamicfilter.domain.service;


import alvarenga.mateus.dynamicfilter.domain.filter.MovieFilter;
import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import alvarenga.mateus.dynamicfilter.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class MovieService {
    @Autowired private MovieRepository movieRepository;

    public Page<Movie> readAll(MovieFilter movieFilter, Pageable pageable){
        return movieRepository.findAll((Specification<Movie>) movieFilter.getSpecification(), pageable);
    }

}
