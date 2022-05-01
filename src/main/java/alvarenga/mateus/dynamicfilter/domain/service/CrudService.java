package alvarenga.mateus.dynamicfilter.domain.service;

import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public class CrudService <T ,R extends JpaRepository & JpaSpecificationExecutor,IDTYPE,FILTER extends Filter> {

    @Autowired R repository;

    public T findById(IDTYPE id) {
        Optional<T> response = repository.findById(id);
        return response.orElse(null);
    }

    public Page<T> readAll(FILTER filter, Pageable pageable){
        return repository.findAll((Specification<T>) filter.getSpecification(), pageable);
    }

    public List<T> list(FILTER filter){
        return repository.findAll((Specification<T>) filter.getSpecification());
    }

    public T save(T entity){
         return (T) repository.save(entity);
    }

    public List<T> saveAll(Iterable<T> entitys){
        return repository.saveAll(entitys);
    }

    public void deleteAll(Iterable<T> entitys){
        repository.deleteAll(entitys);
    }

    public void deleteById(IDTYPE id) {
        try{
            repository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(T entity){
        try{
            repository.delete(entity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
