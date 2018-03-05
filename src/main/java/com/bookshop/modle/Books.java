package com.bookshop.modle;

import java.util.Date;

public class Books {
    private String bId;

    private String bPic;

    private String bName;

    private String bDescription;

    private Float bPrice;

    private Integer bDiscount;

    private String bAuthor;

    private String bPress;

    private Date bPressTime;

    private Date bAddTime;

    private String bService;

    private Integer bSaleNum;

    private Integer bState;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId == null ? null : bId.trim();
    }

    public String getbPic() {
        return bPic;
    }

    public void setbPic(String bPic) {
        this.bPic = bPic == null ? null : bPic.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbDescription() {
        return bDescription;
    }

    public void setbDescription(String bDescription) {
        this.bDescription = bDescription == null ? null : bDescription.trim();
    }

    public Float getbPrice() {
        return bPrice;
    }

    public void setbPrice(Float bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getbDiscount() {
        return bDiscount;
    }

    public void setbDiscount(Integer bDiscount) {
        this.bDiscount = bDiscount;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor == null ? null : bAuthor.trim();
    }

    public String getbPress() {
        return bPress;
    }

    public void setbPress(String bPress) {
        this.bPress = bPress == null ? null : bPress.trim();
    }

    public Date getbPressTime() {
        return bPressTime;
    }

    public void setbPressTime(Date bPressTime) {
        this.bPressTime = bPressTime;
    }

    public Date getbAddTime() {
        return bAddTime;
    }

    public void setbAddTime(Date bAddTime) {
        this.bAddTime = bAddTime;
    }

    public String getbService() {
        return bService;
    }

    public void setbService(String bService) {
        this.bService = bService == null ? null : bService.trim();
    }

    public Integer getbSaleNum() {
        return bSaleNum;
    }

    public void setbSaleNum(Integer bSaleNum) {
        this.bSaleNum = bSaleNum;
    }

    public Integer getbState() {
        return bState;
    }

    public void setbState(Integer bState) {
        this.bState = bState;
    }

	@Override
	public String toString() {
		return "Books [bId=" + bId + ", bPic=" + bPic + ", bName=" + bName + ", bPrice=" + bPrice + ", bDiscount=" + bDiscount + ", bAuthor=" + bAuthor + ", bPress=" + bPress
				+ ", bPressTime=" + bPressTime + ", bAddTime=" + bAddTime + ", bSaleNum="
				+ bSaleNum+ "]";
	}
    
    
}