package com.zeroschools.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zeroschools.crud.Model.Product;
import com.zeroschools.crud.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
public String deleteProduct(@PathVariable Long id) {
    if (productService.findProductById(id) != null) {
        productService.deleteProductById(id);
        return "Product deleted successfully";
    } else {
        return "Product not available"; 
    }
}
@DeleteMapping("/delete/all")
public String deleteAllProducts() {
    productService.deleteAllProducts();
    return "All products deleted successfully";
}



    @GetMapping("/findall")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/find/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/find/title/{title}")
    public List<Product> findProductsByTitle(@PathVariable String title) {
        return productService.findProductsByTitle(title);
    }

    @GetMapping("/find/products/price-range")
    public List<Product> findProductsByPriceRange(@RequestParam double priceStart, @RequestParam double priceEnd) {
        return productService.findProductsByPriceRange(priceStart, priceEnd);
    }
}
