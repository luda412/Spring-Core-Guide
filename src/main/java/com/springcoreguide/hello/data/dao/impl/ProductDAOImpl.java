package com.springcoreguide.hello.data.dao.impl;

import com.springcoreguide.hello.data.dao.ProductDAO;
import com.springcoreguide.hello.data.entity.Product;
import com.springcoreguide.hello.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);
        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> seletedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (seletedProduct.isPresent()){
            Product product = seletedProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());
            updatedProduct = productRepository.save(product);
        }else {
            throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        }else {
            throw new Exception();
        }
    }
}
