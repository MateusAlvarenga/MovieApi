package alvarenga.mateus.dynamicfilter.resource.api;


import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.Filter;
import alvarenga.mateus.dynamicfilter.domain.service.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Crud controller.
 *
 * @param <T>      the type parameter
 * @param <S>      the type parameter
 * @param <IDTYPE> the type parameter
 * @param <FILTER> the type parameter
 */
public abstract class
CrudController <T ,S extends CrudService,IDTYPE,FILTER extends Filter,INPUT,OUTPUT>{

    /**
     * The Service S.
     */
    @Autowired public S service;
    /**
     * The ModelMapper.
     */
    @Autowired ModelMapper modelMapper;

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable IDTYPE id){
        return  ResponseEntity.ok(service.findById(id));
    }

    /**
     * List response entity.
     *
     * @param filter the filter
     * @return the response entity
     */
    @GetMapping("/list")
    public ResponseEntity<?> list(FILTER filter){
        return ResponseEntity.ok(service.list(filter));
    }

    /**
     * Read all response entity.
     *
     * @param filter   the filter
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping("")
    public ResponseEntity<?> readAll(FILTER filter, Pageable pageable){
        return ResponseEntity.ok(service.readAll(filter, pageable));
    }

    /**
     * Save response entity.
     *
     * @param entity the entity
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> save(@RequestBody INPUT entity){
        return ResponseEntity.ok(service.save(entity));
    }

    /**
     * Update response entity.
     *
     * @param entity the entity
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity<?> update(@RequestBody INPUT entity){
        return  ResponseEntity.ok(service.save(entity));
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable IDTYPE id){
        service.deleteById(id);
    }

}
