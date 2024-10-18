package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue
private int pid;
private String ptype;
private String pbrand;
private String pmodel;
private String pimage;
private float pprice;
private int pquantity;
public int getPquantity() {
	return pquantity;
}
public void setPquantity(int pquantity) {
	this.pquantity = pquantity;
}
public String getPtype() {
	return ptype;
}
public void setPtype(String ptype) {
	this.ptype = ptype;
}
public String getPmodel() {
	return pmodel;
}
public void setPmodel(String pmodel) {
	this.pmodel = pmodel;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPbrand() {
	return pbrand;
}
public void setPbrand(String pbrand) {
	this.pbrand = pbrand;
}
public String getPimage() {
	return pimage;
}
public void setPimage(String pimage) {
	this.pimage = pimage;
}
public float getPprice() {
	return pprice;
}
public void setPprice(float pprice) {
	this.pprice = pprice;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", ptype=" + ptype + ", pbrand=" + pbrand + ", pmodel=" + pmodel + ", pimage="
			+ pimage + ", pprice=" + pprice + ", pquantity=" + pquantity + "]";
}

}
