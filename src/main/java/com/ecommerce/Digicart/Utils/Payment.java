package com.ecommerce.Digicart.Utils;

public class Payment {
	
	private String currency;
	private long amount;
	private String receipt;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
}
