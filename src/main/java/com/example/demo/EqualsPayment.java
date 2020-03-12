package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class EqualsPayment {
	//HomeController.loan_data();
	
	
	public List<loan> getpaydata(){
		List<loan> listpayment = new ArrayList<>();
		listpayment.add(new loan("1","10","100","1000","10000"));
		listpayment.add(new loan("2","11","110","1000","10000"));
		listpayment.add(new loan("3","12","120","1000","10000"));
		
		return listpayment;
	}
		
}
