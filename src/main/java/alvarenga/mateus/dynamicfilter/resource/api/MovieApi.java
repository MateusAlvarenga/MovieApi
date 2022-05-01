package alvarenga.mateus.dynamicfilter.resource.api;

import alvarenga.mateus.dynamicfilter.domain.filter.MovieFilter;
import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import alvarenga.mateus.dynamicfilter.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {

    @Autowired MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getAllMovies(MovieFilter movieFilter, Pageable pageable) {
        return ResponseEntity.ok(movieService.readAll(movieFilter,pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllMovies(MovieFilter movieFilter) {
        return ResponseEntity.ok(movieService.list(movieFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllMoviesMooc(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

}
