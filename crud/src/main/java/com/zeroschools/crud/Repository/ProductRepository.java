package com.zeroschools.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zeroschools.crud.Model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :priceStart AND :priceEnd")
    List<Product> findProductsByPriceRange(@Param("priceStart") double priceStart, @Param("priceEnd") double priceEnd);

    @Query("SELECT p FROM Product p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Product> findProductsByTitle(@Param("title") String title);
}
