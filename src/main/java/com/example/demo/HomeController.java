package com.example.demo;

//import java.util.List;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.DecimalFormat;

@Controller
public class HomeController {
	private static DecimalFormat df = new DecimalFormat("0.00");
	private static DecimalFormat df2 = new DecimalFormat("0");
			
	@RequestMapping("home")
	public String home()
	{
		return "home.jsp";
	}
    ArrayList<loan> listdetails = new ArrayList<loan>();
    //List<ArrayList<loan>> listdet = new  ArrayList<ArrayList<loan>>();
    
	@PostMapping("/saveDetails")
    public String loan_data(@RequestParam("lamount") double lamount,
                              @RequestParam("annrate") double annrate,
                              @RequestParam("lperiod") int lperiod,
                              ModelMap modelMap) {
		listdetails.clear();
        // write your code to save details
        modelMap.put("lamount", lamount);
        modelMap.put("annrate", annrate);
        modelMap.put("lperiod", lperiod);
        
        
        System.out.println("loan amount : " + lamount);
        System.out.println("annual rate" + annrate);
        System.out.println("lperiod" + lperiod);
        
        for (int i = 1; i <= lperiod; i++) {
        	
        int no = i;
        String number = df2.format(no);
        
        
        double annrate1 = annrate/100.0;
        System.out.println("annrate1 : " + annrate1);
        double annualrate = annrate1/12;
        System.out.println("annualrate : " + annualrate);
        double a = 1 + annualrate;
        System.out.println("a : " + a);
        double b = lperiod;
        System.out.println("b : " + b);
        double exp = Math.pow(a, b);
        System.out.println("exp : " + exp);
        double pay1 = annualrate * lamount * exp;
        System.out.println("pay1 : " + pay1);
        double pay2 = exp - 1;
        System.out.println("pay2 : " + pay2);
        double pay = pay1/pay2;
        System.out.println("pay : " + pay);
        String paymount = df.format(pay);
        System.out.println("Paymount : " + paymount);
        
        double a1 = 1 + annualrate;
        double a2 = -1-lperiod+no;
        double exp1 = Math.pow(a1,a2);
        double principle = pay * exp1;
        String pp = df.format(principle);
        System.out.println("pp : " + pp);
        
        double interest1 = pay - principle;
        String interest = df.format(interest1);
        System.out.println("interest : " + interest);
        
        double outbal1 = (interest1/annualrate) - principle;
        String outbal = df.format(outbal1);
        System.out.println("outbal : " + outbal);
        
    	listdetails.add(new loan(number,paymount,pp,interest,outbal));
    		
        }
        modelMap.addAttribute("listpayment",listdetails);
        return "loan.jsp";
                  
    }
}
