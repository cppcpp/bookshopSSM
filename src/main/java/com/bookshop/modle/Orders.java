package com.bookshop.modle;

import java.util.Date;

public class Orders {
    private String oId;

    private Integer oNum;

    private Float oPrice;

    private Date oTime;

    private String uAccount;

    private String uAddress;

    private String oPhone;

    private String uReceiver;

    private Float oCheaper;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    public Integer getoNum() {
        return oNum;
    }

    public void setoNum(Integer oNum) {
        this.oNum = oNum;
    }

    public Float getoPrice() {
        return oPrice;
    }

    public void setoPrice(Float oPrice) {
        this.oPrice = oPrice;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress == null ? null : uAddress.trim();
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone == null ? null : oPhone.trim();
    }

    public String getuReceiver() {
        return uReceiver;
    }

    public void setuReceiver(String uReceiver) {
        this.uReceiver = uReceiver == null ? null : uReceiver.trim();
    }

    public Float getoCheaper() {
        return oCheaper;
    }

    public void setoCheaper(Float oCheaper) {
        this.oCheaper = oCheaper;
    }
}