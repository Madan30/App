package com.syntechnepal.Repository;

import com.syntechnepal.AbstractRepository.AbstractRepository;
import com.syntechnepal.Entities.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mrg1813
 */
@Stateless
public class ProductRepository extends AbstractRepository<Product> {

    @PersistenceContext(name = "MD")
    private EntityManager entityManager;

    public ProductRepository() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return entityManager;
    }

}
