package com.bookshop.modle;

import java.util.Date;

public class UserMessage {
    private String uAccount;

    private String uMessage;

    private Date uAddTime;

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuMessage() {
        return uMessage;
    }

    public void setuMessage(String uMessage) {
        this.uMessage = uMessage == null ? null : uMessage.trim();
    }

    public Date getuAddTime() {
        return uAddTime;
    }

    public void setuAddTime(Date uAddTime) {
        this.uAddTime = uAddTime;
    }
}