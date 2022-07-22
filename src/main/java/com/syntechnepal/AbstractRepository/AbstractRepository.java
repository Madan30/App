package com.syntechnepal.AbstractRepository;

import com.syntechnepal.Interface.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.syntechnepal.Interface.EntityInterface;

/**
 *
 * @author mrg1813
 * @param <T>
 */
public abstract class AbstractRepository<T extends EntityInterface> implements Repository<T> {

    protected abstract EntityManager getEntityManager();
    private final Class<T> entityClass;

    public AbstractRepository(Class<T> entClass) {
        this.entityClass = entClass;
    }

    @Override
    public void create(T t) {
        getEntityManager().persist(t);
        getEntityManager().flush();
    }

    @Override
    public void edit(T t) {
        getEntityManager().merge(t);
        getEntityManager().flush();
    }

    @Override
    public void delete(T t) {
        getEntityManager().remove(findById(t.getId()));
        getEntityManager().flush();
    }

    @Override
    public T findById(Long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("Select t from " + entityClass.getName() + " t ").getResultList();
    }

    @Override
    public Boolean isUnique(T t, String uniqueColumn, Object newValue, Long id) {
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(e)"
                    + " FROM " + t.getClass().getName() + "e"
                    + " WHERE e. " + uniqueColumn + " =:value";
            if (id != null) {
                sql = sql + "and e.id != id";
            }
            Query query = getEntityManager().createQuery(sql, Long.class);
            query.setParameter("value", newValue);
            if (id != null) {
                query.setParameter("id", id);
            }
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            count = 1L;
        }
        return count != null && count == 0L ? Boolean.TRUE : Boolean.FALSE;
    }

}
