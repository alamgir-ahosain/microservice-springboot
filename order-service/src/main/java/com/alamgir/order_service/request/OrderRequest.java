package com.alamgir.order_service.request;

import java.util.List;

public class OrderRequest {
    private Long userId;
    private double totalAmount;
    private List<productInfoRequest> productInfo;

    public Long getUserId() { return userId;}
    public void setUserId(Long userId) {      this.userId = userId;  }
    public double getTotalAmount() {    return totalAmount;   }
    public void setTotalAmount(double totalAmount) {  this.totalAmount = totalAmount; }
    public List<productInfoRequest> getProductInfo() {  return productInfo; }
    public void setProductInfo(List<productInfoRequest> productInfo) {     this.productInfo = productInfo; }

}
