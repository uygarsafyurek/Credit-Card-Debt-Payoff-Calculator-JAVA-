
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

		double overPayment = monthlyPayment * (monthsNeededToPayOff - monthsRaw);
		
		
		//printouts
		System.out.println("\nMonths Needed To Pay Off: \t"+ monthsNeededToPayOff);
		System.out.printf(Locale.US, "Total Amount Paid: \t\t$%.2f%n", totalAmountPaid);
		System.out.printf(Locale.US, "Total Interest Paid: \t\t$%.2f%n", totalInterestPaid);
		System.out.printf(Locale.US, "Overpayment: \t\t\t$%.2f%n", overPayment);
	
		input.close();
	
	}

}
