package com.anonym.spring.pojo;

import java.io.Serializable;

public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long shopId;
    private String shopName;
    private Double shopAllCount;
    private Long shopUserId;
    private Long otherLegalId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getShopAllCount() {
        return shopAllCount;
    }

    public void setShopAllCount(Double shopAllCount) {
        this.shopAllCount = shopAllCount;
    }

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    public Long getOtherLegalId() {
        return otherLegalId;
    }

    public void setOtherLegalId(Long otherLegalId) {
        this.otherLegalId = otherLegalId;
    }
}
