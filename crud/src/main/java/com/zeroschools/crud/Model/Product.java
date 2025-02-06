package com.zeroschools.crud.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private Date mfgDate;
    private Date expDate;
    private LocalDateTime recordCreated;

    @PrePersist
    protected void onCreate() {
        recordCreated = LocalDateTime.now();
    }
}
