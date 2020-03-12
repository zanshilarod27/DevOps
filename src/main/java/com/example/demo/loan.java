package com.example.demo;

public class loan {
	private String paynumber;
	private String payamount;
	private String principle;
	private String interest;
	private String outbal;
	public loan(String paynumber, String payamount, String principle, String interest, String outbal) {
		super();
		this.paynumber = paynumber;
		this.payamount = payamount;
		this.principle = principle;
		this.interest = interest;
		this.outbal = outbal;
	}
	
	public String getPaynumber() {
		return paynumber;
	}
	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}
	public String getPayamount() {
		return payamount;
	}
	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}
	public String getPrinciple() {
		return principle;
	}
	public void setPrinciple(String principle) {
		this.principle = principle;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getOutbal() {
		return outbal;
	}
	public void setOutbal(String outbal) {
		this.outbal = outbal;
	}
	
}
