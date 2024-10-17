package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
@Id
private String emailid;
private String emailpassword;
@Override
public String toString() {
	return "Login [emailid=" + emailid + ", emailpassword=" + emailpassword + "]";
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getEmailpassword() {
	return emailpassword;
}
public void setEmailpassword(String emailpassword) {
	this.emailpassword = emailpassword;
}
}
