package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", tDate=" + tDate + ", quantity=" + quantity + ", value=" + value
				+ ", product=" + product + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime gettDate() {
		return tDate;
	}
	public void settDate(LocalDateTime tDate) {
		this.tDate = tDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	@Id
	@GeneratedValue
	private int id;
	private LocalDateTime tDate;
	private int quantity;
	private float value;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
