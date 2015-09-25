package com.allere.hibernate.entity;

/**
 * Created by G_dragon on 2015/7/16.
 */

/**
 * 联系方式的逻辑实体component
 */
public class Contact {

    private String email;
    private String address;
    private String zipCode;
    private String tel;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
