package com.alamgir.order_service.request;

public class productInfoRequest {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;  }
    public double getPrice() {   return price;}
    public void setPrice(double price) {   this.price = price; }

}
