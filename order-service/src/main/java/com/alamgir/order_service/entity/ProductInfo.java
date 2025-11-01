package com.alamgir.order_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_info")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "product name Can't be Null")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "price Can't be Null")
    @Column(nullable = false)
    private double price;

    public Long getId() { return id; }
    public void setId(Long id) {     this.id = id; }
    public String getName() {      return name;   }
    public void setName(String name) { this.name = name; }
    public double getPrice() {   return price;  }
    public void setPrice(double price) {this.price = price;  }

}