package com.alamgir.order_service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "userId Can't be Null")
    @Column( nullable = false)
    private Long userId;

    @NotNull(message = "totalAmount Can't be Null")
    @Column(nullable = false)
    private double totalAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    List<ProductInfo> productInfo = new ArrayList<>();

    public Long getId() {return id;  }
    public void setId(Long id) {     this.id = id;   }
    public Long getUserId() {   return userId;  }
    public void setUserId(Long userId) {     this.userId = userId; }
    public double getTotalAmount() {  return totalAmount;}
    public void setTotalAmount(double totalAmount) {   this.totalAmount = totalAmount;    }
    public List<ProductInfo> getProductInfo() {return productInfo;  }
    public void setProductInfo(List<ProductInfo> productInfo) {     this.productInfo = productInfo; }

}

/*
 * "userId":1,
 * "totalAmount":112.12,
 * "productInfo":[
 * {
 * "name":"Phone",
 * "price":10000
 * }
 * ]
 * 
 */