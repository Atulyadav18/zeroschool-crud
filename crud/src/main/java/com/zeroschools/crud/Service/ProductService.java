package com.zeroschools.crud.Service;

import java.util.List;

import com.zeroschools.crud.Model.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProductById(Long id);
    void deleteAllProducts();
    List<Product> findAllProducts();
    Product findProductById(Long id);
    List<Product> findProductsByPriceRange(double start, double end);
    List<Product> findProductsByTitle(String title);
 
}
