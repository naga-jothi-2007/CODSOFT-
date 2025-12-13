package task3;



import java.util.Scanner;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 // Deposit amount
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Amount Deposited Successfully!");
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 // Withdraw amount
 public void withdraw(double amount) {
     if (amount > balance) {
         System.out.println("Insufficient balance! Withdrawal failed.");
     } else if (amount <= 0) {
         System.out.println("Invalid withdrawal amount!");
     } else {
         balance -= amount;
         System.out.println("Withdrawal Successful!");
     }
 }

 // Check balance
 public double getBalance() {
     return balance;
 }
}



class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void start() {
     Scanner sc = new Scanner(System.in);
     int choice;

     System.out.println("----- Welcome to ATM -----");

     do {
         System.out.println("\nChoose an option:");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit Amount");
         System.out.println("3. Withdraw Amount");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 System.out.println("Your Balance: ₹" + account.getBalance());
                 break;

             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double dep = sc.nextDouble();
                 account.deposit(dep);
                 break;

             case 3:
                 System.out.print("Enter amount to withdraw: ");
                 double wd = sc.nextDouble();
                 account.withdraw(wd);
                 break;

             case 4:
                 System.out.println("Thank you for using the ATM!");
                 break;

             default:
                 System.out.println("Invalid choice. Please try again.");
         }

     } while (choice != 4);
 }
}


 public class ATMInterface {

 public static void main(String[] args) {

  
     BankAccount userAccount = new BankAccount(5000.00);  

  
     ATM atm = new ATM(userAccount);

    
     atm.start();
 }
 }

