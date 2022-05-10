package alvarenga.mateus.dynamicfilter.domain.service;


import alvarenga.mateus.dynamicfilter.domain.model.searchSpec.Filter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Crud service.
 *
 * @param <T>      the type parameter
 * @param <R>      the type parameter
 * @param <IDTYPE> the type parameter
 * @param <FILTER> the type parameter
 */
@SuppressWarnings("unchecked")
public abstract class CrudService
        <T ,R extends JpaRepository & JpaSpecificationExecutor,IDTYPE,FILTER extends Filter, INPUT, OUTPUT> {

    /**
     * The Repository.
     */
    @Autowired R repository;
    /**
     * The ModelMapper.
     */
    @Autowired ModelMapper modelMapper;

    /**
     * Find by id t.
     *
     * @param id the id
     * @return the t
     */
    public T findById(IDTYPE id) {
        Optional<T> response = repository.findById(id);
        return response.map(t -> modelMapper.map(t, getOutputType())).orElse(null);
    }

    /**
     * Read all page.
     *
     * @param filter   the filter
     * @param pageable the pageable
     * @return the page
     */
    public Page<T> readAll(FILTER filter, Pageable pageable){
        return repository.findAll(filter.getSpecification(), pageable).map(
                content -> modelMapper.map(content,getOutputType()));
    }

    /**
     * List list.
     *
     * @param filter the filter
     * @return the list
     */
    public List<T> list(FILTER filter){
        return (List<T>) repository.findAll(filter.getSpecification()).stream().map(
                content -> modelMapper.map(content,getOutputType())).collect(Collectors.toList());
    }

    /**
     * Save t.
     *
     * @param entity the entity
     * @return the t
     */
    public T save(INPUT entity){
        T entityToBeSaved = modelMapper.map(entity,getEntityType());
        T savedEntity = (T) repository.save(entityToBeSaved);
        return modelMapper.map(savedEntity, getOutputType());
    }

    /**
     * Save all list.
     *
     * @param entitys the entitys
     * @return the list
     */
    public List<T> saveAll(Iterable<INPUT> entitys){
        List<T> savedEntitys =  repository.saveAll(entitys);
        return  savedEntitys.stream().map(
                content -> modelMapper.map(content,getOutputType())).collect(Collectors.toList());
    }

    /**
     * Delete all.
     *
     * @param entitys the entitys
     */
    public void deleteAll(Iterable<T> entitys){
        repository.deleteAll(entitys);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(IDTYPE id) {
        try{
            repository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity){
        try{
            repository.delete(entity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected Class<T> getOutputType(){
        ParameterizedType types = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) types.getActualTypeArguments()[5];
    }

    protected Class<T> getEntityType(){
        ParameterizedType types = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) types.getActualTypeArguments()[0];
    }
}
