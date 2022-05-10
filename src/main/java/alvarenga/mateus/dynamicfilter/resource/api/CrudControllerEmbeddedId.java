package alvarenga.mateus.dynamicfilter.resource.api;

import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.Filter;
import alvarenga.mateus.dynamicfilter.domain.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Crud controller embedded.
 *
 * @param <T>      the type parameter
 * @param <S>      the type parameter
 * @param <IDTYPE> the type parameter
 * @param <FILTER> the type parameter
 */
public abstract class
CrudControllerEmbeddedId<T ,S extends CrudService,IDTYPE,FILTER extends Filter,INPUT,OUTPUT>
        extends CrudController<T ,S ,IDTYPE,FILTER,INPUT,OUTPUT>  {

    @GetMapping("/id")
    @Override
    public ResponseEntity<?> findById(IDTYPE id){
        return  ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping
    @Override
    public void delete(IDTYPE id){
        service.delete(id);
    }
}
