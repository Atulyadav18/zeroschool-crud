package com.zeroschools.crud.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeroschools.crud.Model.Product;
import com.zeroschools.crud.Repository.ProductRepository;
import com.zeroschools.crud.Service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();  // This deletes all products
    }


    @Override
    public List<Product> findProductsByPriceRange(double priceStart, double priceEnd) {
        return productRepository.findProductsByPriceRange(priceStart, priceEnd);
    }
  

    @Override
    public List<Product> findProductsByTitle(String title) {
        return productRepository.findProductsByTitle(title);
    }
}
