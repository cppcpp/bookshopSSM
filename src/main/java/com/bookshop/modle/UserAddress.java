package com.bookshop.modle;

public class UserAddress {
    private String uaddrId;

    private String uAccount;

    private String uAddress;

    private String oPhone;

    private Integer uIsdefault;

    private String oReceiver;

    public String getUaddrId() {
        return uaddrId;
    }

    public void setUaddrId(String uaddrId) {
        this.uaddrId = uaddrId == null ? null : uaddrId.trim();
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

    public Integer getuIsdefault() {
        return uIsdefault;
    }

    public void setuIsdefault(Integer uIsdefault) {
        this.uIsdefault = uIsdefault;
    }

    public String getoReceiver() {
        return oReceiver;
    }

    public void setoReceiver(String oReceiver) {
        this.oReceiver = oReceiver == null ? null : oReceiver.trim();
    }
}