package com.bookshop.modle;

public class BookImages {
    private String bId;

    private String bImg;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId == null ? null : bId.trim();
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg == null ? null : bImg.trim();
    }
}