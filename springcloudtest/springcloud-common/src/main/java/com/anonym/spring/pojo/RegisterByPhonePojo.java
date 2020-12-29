package com.anonym.spring.pojo;

import java.io.Serializable;

public class RegisterByPhonePojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mobile;
    private String appkey;
    private String content;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
