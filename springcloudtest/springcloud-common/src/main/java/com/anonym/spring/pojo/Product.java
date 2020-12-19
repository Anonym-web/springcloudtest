package com.anonym.spring.pojo;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long productId;
    private String productName;
    private Integer productCount;
    private Double productBalance;
    private Long shopId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getProductBalance() {
        return productBalance;
    }

    public void setProductBalance(Double productBalance) {
        this.productBalance = productBalance;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
