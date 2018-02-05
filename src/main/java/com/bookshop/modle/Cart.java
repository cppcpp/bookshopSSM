package com.bookshop.modle;

public class Cart {
    private String cId;

    private String uAccount;

    private String bId;

    private String bName;

    private Integer bNums;

    private Float bPrice;

    private Float bDiscountprice;

    private Float bSumprice;

    private Float bSumdiscountprice;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId == null ? null : bId.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public Integer getbNums() {
        return bNums;
    }

    public void setbNums(Integer bNums) {
        this.bNums = bNums;
    }

    public Float getbPrice() {
        return bPrice;
    }

    public void setbPrice(Float bPrice) {
        this.bPrice = bPrice;
    }

    public Float getbDiscountprice() {
        return bDiscountprice;
    }

    public void setbDiscountprice(Float bDiscountprice) {
        this.bDiscountprice = bDiscountprice;
    }

    public Float getbSumprice() {
        return bSumprice;
    }

    public void setbSumprice(Float bSumprice) {
        this.bSumprice = bSumprice;
    }

    public Float getbSumdiscountprice() {
        return bSumdiscountprice;
    }

    public void setbSumdiscountprice(Float bSumdiscountprice) {
        this.bSumdiscountprice = bSumdiscountprice;
    }
}