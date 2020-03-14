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
	//Creating an arraylist of type loan - which is my class 
    ArrayList<loan> listdetails = new ArrayList<loan>();
    
	@PostMapping("/saveDetails")
    public String loan_data(@RequestParam("lamount") double lamount,
                              @RequestParam("annrate") double annrate,
                              @RequestParam("lperiod") int lperiod,
                              ModelMap modelMap) {
		listdetails.clear();
        // saving the details input by the user
        modelMap.put("lamount", lamount);//loan amount
        modelMap.put("annrate", annrate);//annual interest rate
        modelMap.put("lperiod", lperiod);//loan period
        
        for (int i = 1; i <= lperiod; i++) {
        	
        int no = i;
        String number = df2.format(no);
             
        double annrate1 = annrate/100.0;
        double annualrate = annrate1/12;
        double a = 1 + annualrate;
        double b = lperiod;
        double exp = Math.pow(a, b);
        double pay1 = annualrate * lamount * exp;
        double pay2 = exp - 1;
        double pay = pay1/pay2;
        
        //monthly payment details
        String paymount = df.format(pay);
        
        double a1 = 1 + annualrate;
        double a2 = -1-lperiod+no;
        double exp1 = Math.pow(a1,a2);
        double principle = pay * exp1;
        
        //monthly principle amount
        String pp = df.format(principle);
        
        double interest1 = pay - principle;
        //monthly interest amount
        String interest = df.format(interest1);
        
        double outbal1 = (interest1/annualrate) - principle;
        //monthly outstanding balance
        String outbal = df.format(outbal1);
        
    	listdetails.add(new loan(number,paymount,pp,interest,outbal));
    		
        }
        //passing the values
        modelMap.addAttribute("listpayment",listdetails);
        return "loan.jsp";
                  
    }
}
