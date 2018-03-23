package com.bookshop.modle;

import java.io.Serializable;

public class Users implements Serializable{
    private String uAccount;

    private String uName;

    private String uPassword;

    private String uPhone;

    private String uMail;

    private String uRole;
    
    public Users(String uAccount,String uPassword) {
    	this.uAccount=uAccount;
    	this.uPassword=uPassword;
    }
    
    public Users(String uAccount,String uPassword,String uPhone,String uRole) {
    	this.uAccount=uAccount;
    	this.uPassword=uPassword;
    	this.uPhone=uPhone;
    	this.uRole=uRole;
    }
    
    public Users(String uAccount, String uName, String uPassword, String uPhone, String uMail, String uRole) {
		super();
		this.uAccount = uAccount;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.uMail = uMail;
		this.uRole = uRole;
	}

    public Users() {
    	
    }
    
	public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail == null ? null : uMail.trim();
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole == null ? null : uRole.trim();
    }
}