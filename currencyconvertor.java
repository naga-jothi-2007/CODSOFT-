package task4;
import java.util.Scanner;

public class currencyconvertor {

 
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.println("Choose Base Currency:");
	        System.out.println("1. USD");
	        System.out.println("2. INR");
	        int base = sc.nextInt();

	        System.out.println("Choose Target Currency:");
	        System.out.println("1. USD");
	        System.out.println("2. INR");
	        int target = sc.nextInt();

	        System.out.print("Enter amount: ");
	        double amount = sc.nextDouble();

	        double rate = 0;

	        // Fixed exchange rates
	        if (base == 1 && target == 2) {
	            rate = 83.0;   // USD → INR
	        } else if (base == 2 && target == 1) {
	            rate = 0.012; // INR → USD
	        } else {
	            rate = 1;     // Same currency
	        }

	        double convertedAmount = amount * rate;

	        System.out.println("Converted Amount: " + convertedAmount);
	    
	}


}
