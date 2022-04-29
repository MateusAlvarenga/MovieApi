package alvarenga.mateus.dynamicfilter.domain.SpecificationBuilder;

import alvarenga.mateus.dynamicfilter.domain.filter.Filter;
import alvarenga.mateus.dynamicfilter.domain.filter.MovieFilter;
import alvarenga.mateus.dynamicfilter.domain.model.entity.Movie;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Pageable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@CommonsLog
public class SpecificationBuilder {

    public static Specification<?> build(Filter filter, Pageable pageable) {

        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            Class<?> clazz = filter.getClass();

            for(Field field : clazz.getDeclaredFields()) {
                //you can also use .toGenericString() instead of .getName(). This will
                //give you the type information as well.

                System.out.println(field.getName());
                log.info(field.getName());
            }

            return null;

//            List<Order> orderList = QueryUtils.toOrders(pageable.getSort(), root, builder);
//            query.orderBy(orderList);
//
//            if (filter.getId() != null) {
//                predicateList.add(builder.equal(root.get(S1020InfoProdJudTerceiros_.ID), filter.getId()));
//            }
//            if (filter.getS1020Filter() != null) {
//                Join<S1020InfoProdJudTerceiros, S1020> s1020Join = root.join(S1020InfoProdJudTerceiros_.S1020);
//                predicateList.addAll(S1020Spec.defineRestrictions(filter.getS1020Filter(), s1020Join, builder));
//
//            }
//            if (filter.getCodTerc() != null) {
//                predicateList.add(builder.equal(root.get(S1020InfoProdJudTerceiros_.COD_TERC), filter.getCodTerc()));
//            }
//            if (filter.getNrProcJud() != null) {
//                predicateList.add(builder.like(builder.upper(root.get(S1020InfoProdJudTerceiros_.NR_PROC_JUD)),
//                        "%" + filter.getNrProcJud().toUpperCase() + "%"));
//            }
//            if (filter.getCodSusp() != null) {
//                predicateList.add(builder.equal(root.get(S1020InfoProdJudTerceiros_.COD_SUSP), filter.getCodSusp()));
//            }
//            return builder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }
}
