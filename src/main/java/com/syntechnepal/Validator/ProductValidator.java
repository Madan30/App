package com.syntechnepal.Validator;

import com.syntechnepal.AbstractRepository.AbstractRepository;
import com.syntechnepal.Entities.Product;
import com.syntechnepal.Repository.ProductRepository;
import javax.enterprise.context.RequestScoped;
import javax.faces.validator.FacesValidator;
import javax.inject.Inject;

/**
 *
 * @author mrg1813
 */
@RequestScoped
@FacesValidator("productValidator")
public class ProductValidator extends AbstractValidator<Product> {

    @Inject
    private ProductRepository productRepository;

    @Override
    protected AbstractRepository getAbstractRepository() {
        return productRepository;
    }

}
