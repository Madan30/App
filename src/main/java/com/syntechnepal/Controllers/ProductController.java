package com.syntechnepal.Controllers;

import com.syntechnepal.Entities.Product;
import com.syntechnepal.Repository.ProductRepository;
import com.syntechnepal.Utls.MessageUtls;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mrg1813
 */
@Named
@ViewScoped
public class ProductController implements Serializable {

    private Product product;
    private List<Product> productList;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private MessageUtls messageUtls;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @PostConstruct
    public void init() {
        this.product = new Product();
        this.productList = productRepository.findAll();
    }

    public void beforeCreate() {
        this.product = new Product();

    }

    public void create() {
        try {
            productRepository.create(product);
            productList = productRepository.findAll();
            messageUtls.showInfo("Product Added Successfully", "Added Product");
        } catch (Exception e) {
            System.out.println("Product create successfully----------------");
            messageUtls.showError("Message", "Failed to add Product !!!");
        }

    }

    public void beforeEdit(Product product) {
        this.product = productRepository.findById(product.getId());

    }

    public void edit() {
        try {
            productRepository.edit(product);
            productList = productRepository.findAll();
            messageUtls.showInfo("Product Upadated Successfully", "Update Product");
        } catch (Exception e) {
            messageUtls.showError("Message", "Failed to update product !!");
        }
    }

    public void delete() {
        productRepository.delete(product);
        productList = productRepository.findAll();
        messageUtls.showInfo("Product Deleted Successfully", "Deleted Product");
    }

    public void findAll() {
        productRepository.findAll();
    }

    public void findById(Long id) {
        productRepository.findById(id);
    }

}
