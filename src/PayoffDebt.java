

/*
  PayoffDebt.java
  Author:  Uygar Safyurek 
  Submission Date:  [09/05/2025]
 
  [Purpose: Calculating how many months it will take to pay off
  credit card debt and reporting the total amount paid,
  total interest paid, and overpayment.]
 
  Statement of Academic Honesty:
 
  The following code represents my own work. I have neither 
  received nor given inappropriate assistance. I have not copied 
  or modified code from any source other than the course webpage 
  or the course textbook. I recognize that any unauthorized 
  assistance or plagiarism will be handled in accordance with 
  the University of Georgia's Academic Honesty Policy and the 
  policies of this course. I recognize that my work is based 
  on an assignment created by the School of Computing 
  at the University of Georgia. Any publishing or
  posting of source code for this assignment is strictly 
  prohibited unless you have written consent from the 
  School of Computing at the University of Georgia.  
 */

import java.util.Scanner;
import java.util.Locale;
public class PayoffDebt {

	public static void main(String[] args) {
		

		//inputs from user
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		System.out.print("Principal: \t\t\t");
		double principal = input.nextDouble();	
		
		System.out.print("Annual Interest Rate (%): \t");
		double annualInterestRate = input.nextDouble();
		
		System.out.print("Monthly Payment: \t\t");
		double monthlyPayment = input.nextDouble();
		
		
		//calculations
		double monthlyInterestRate = annualInterestRate / 1200.0;
		double principalReduction = monthlyPayment - (monthlyInterestRate * principal);
		double monthsRaw = (Math.log(monthlyPayment) - Math.log(principalReduction)) / Math.log(monthlyInterestRate + 1.0);
		int monthsNeededToPayOff = (int) Math.ceil(monthsRaw);
		double totalAmountPaid = monthsNeededToPayOff * monthlyPayment;
		double totalInterestPaid = totalAmountPaid - principal;
		
		
		/*
		  Overpayment pseudocode:
		 
		  monthsRaw = the exact months from the formula 
		  monthsNeededToPayOff = monthsRaw rounded up 
		  monthlyPayment = the fixed payment each month
		 
		  Why is there overpayment?
		  The real payoff time is monthsRaw.
		  But we can only pay in whole months.
		  So in the last month we pay a little extra.
		 
		  Calculation:
		    overPayment = monthlyPayment * (monthsNeededToPayOff - monthsRaw)
		 */
		double overPayment = monthlyPayment * (monthsNeededToPayOff - monthsRaw);
		
		
		//printouts
		System.out.println("\nMonths Needed To Pay Off: \t"+ monthsNeededToPayOff);
		System.out.printf(Locale.US, "Total Amount Paid: \t\t$%.2f%n", totalAmountPaid);
		System.out.printf(Locale.US, "Total Interest Paid: \t\t$%.2f%n", totalInterestPaid);
		System.out.printf(Locale.US, "Overpayment: \t\t\t$%.2f%n", overPayment);
	
		input.close();
	
	}

}
