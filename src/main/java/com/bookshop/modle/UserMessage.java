package com.bookshop.modle;

public class UserMessage {
    private String uAccount;

    private String uMessage;

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
}